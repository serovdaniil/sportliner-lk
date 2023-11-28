package by.sportliner.lk.endpoint.common;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class RequestLoggingFilter extends OncePerRequestFilter implements OrderedFilter {

    private final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 2;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        boolean isFirstRequest = !isAsyncDispatch(request);

        boolean shouldLog = logger.isDebugEnabled();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        if (shouldLog && isFirstRequest) {
            beforeRequest(request);
        }

        try {
            filterChain.doFilter(request, response);
        }
        finally {
            stopWatch.stop();
            if (shouldLog && !isAsyncStarted(request)) {
                afterRequest(request, response, stopWatch);
            }
        }
    }

    private void beforeRequest(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();

        sb.append(">>> ");
        sb.append(request.getMethod());
        sb.append(" '");
        sb.append(request.getRequestURI());
        if (request.getQueryString() != null) {
            sb.append("?").append(request.getQueryString());
        }
        sb.append("'");


        logger.debug(sb.toString());
    }

    private void afterRequest(HttpServletRequest request, HttpServletResponse response, StopWatch stopWatch) {
        StringBuilder sb = new StringBuilder();

        sb.append("<<< ");
        sb.append(request.getMethod());
        sb.append(" '");
        sb.append(request.getRequestURI());
        if (request.getQueryString() != null) {
            sb.append("?").append(request.getQueryString());
        }
        sb.append("'");

        sb.append(" <<<: ");

        sb.append(response.getStatus());
        sb.append(" (");
        HttpStatus status = HttpStatus.resolve(response.getStatus());
        sb.append(status != null ? status.name() : "???");
        sb.append(") : ");

        sb.append("time=").append(stopWatch.getTotalTimeMillis());

        logger.debug(sb.toString());
    }

}
