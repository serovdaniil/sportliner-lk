package by.sportliner.lk.core.service.email;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "integration.email")
public class EmailServiceProperties extends MailProperties {

    private String from;

    private int recipientsLimit = Integer.MAX_VALUE;

    public String getFrom() {
        return from;
    }

    public EmailServiceProperties setFrom(String from) {
        this.from = from;
        return this;
    }

    public int getRecipientsLimit() {
        return recipientsLimit;
    }

    public EmailServiceProperties setRecipientsLimit(int recipientsLimit) {
        if (recipientsLimit <= 0) {
            throw new IllegalArgumentException("Invalid value for recipientsLimit: " + recipientsLimit);
        }
        this.recipientsLimit = recipientsLimit;
        return this;
    }

}
