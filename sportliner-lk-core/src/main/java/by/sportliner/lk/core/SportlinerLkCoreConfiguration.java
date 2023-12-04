package by.sportliner.lk.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(
    basePackageClasses = {
        SportlinerLkCoreConfiguration.class
    }
)
@EnableAutoConfiguration
@EnableScheduling
@EnableJpaRepositories(basePackages = {"by.sportliner.lk.core.repository"})
public class SportlinerLkCoreConfiguration {

}
