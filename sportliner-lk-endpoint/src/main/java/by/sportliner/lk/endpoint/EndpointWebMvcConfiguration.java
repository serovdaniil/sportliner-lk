package by.sportliner.lk.endpoint;

import by.sportliner.lk.endpoint.common.RequestLoggingFilter;
import by.sportliner.lk.core.support.json.json.JacksonObjectMappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class EndpointWebMvcConfiguration implements WebMvcConfigurer {

    @Bean
    public RequestLoggingFilter requestLoggingFilter() {
        return new RequestLoggingFilter();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(
            SportlinerLkApiMeta.API_PATH_PREFIX, HandlerTypePredicate.forBasePackageClass(SportlinerLkApiMeta.class)
        );
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream()
            .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
            .map(converter -> (MappingJackson2HttpMessageConverter) converter)
            .forEach(converter -> converter.setObjectMapper(JacksonObjectMappers.defaultStrict()));
    }

}
