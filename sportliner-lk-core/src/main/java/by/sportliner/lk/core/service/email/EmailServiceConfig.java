package by.sportliner.lk.core.service.email;

import by.sportliner.lk.core.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Map;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties(EmailServiceProperties.class)
public class EmailServiceConfig {

    @Autowired
    private UserAccountService userAccountService;

    @Bean
    public EmailService emailService(EmailServiceProperties properties) {
        return new EmailServiceImpl(
            createSender(properties), properties.getFrom(), properties.getRecipientsLimit(), userAccountService
        );
    }

    private JavaMailSender createSender(EmailServiceProperties properties) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        sender.setHost(properties.getHost());

        if (properties.getPort() != null) {
            sender.setPort(properties.getPort());
        }

        sender.setUsername(properties.getUsername());
        sender.setPassword(properties.getPassword());

        sender.setProtocol(properties.getProtocol());

        if (properties.getDefaultEncoding() != null) {
            sender.setDefaultEncoding(properties.getDefaultEncoding().name());
        }

        if (!properties.getProperties().isEmpty()) {
            sender.setJavaMailProperties(asProperties(properties.getProperties()));
        }

        return sender;
    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }
}
