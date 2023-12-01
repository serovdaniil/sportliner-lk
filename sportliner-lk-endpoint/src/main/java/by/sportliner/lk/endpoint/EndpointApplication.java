package by.sportliner.lk.endpoint;

import by.sportliner.lk.core.SportlinerLkCoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SportlinerLkCoreConfiguration.class)
public class EndpointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndpointApplication.class, args);
    }

}
