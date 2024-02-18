package by.sportliner.lk.core.service.email;

import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Email {

    private final List<String> to;

    private final String subject;

    private final String plainText;

    private final String htmlText;

    private final List<Resource> attachments;

    private final List<Resource> inlineImages;

    private Email(Builder builder) {
        this.to = Objects.requireNonNull(builder.to);
        this.subject = Objects.requireNonNull(builder.subject);
        this.plainText = builder.plainText;
        this.htmlText = builder.htmlText;
        this.attachments = new ArrayList<>(builder.attachments);
        this.inlineImages = new ArrayList<>(builder.inlineImages);
    }

    public List<String> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getPlainText() {
        return plainText;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public List<Resource> getAttachments() {
        return attachments;
    }

    public List<Resource> getInlineImages() {
        return inlineImages;
    }

    public static class Builder {

        public static Builder copyOf(Email email) {
            return new Builder()
                .to(email.to)
                .subject(email.subject)
                .plainText(email.plainText)
                .htmlText(email.htmlText)
                .addAttachments(email.attachments)
                .addInlineImages(email.inlineImages);
        }

        private List<String> to;
        private String subject;
        private String plainText;
        private String htmlText;
        private List<Resource> attachments = new ArrayList<>();
        private List<Resource> inlineImages = new ArrayList<>();

        public Builder to(List<String> to) {
            this.to = to;
            return this;
        }

        public Builder to(String to) {
            this.to = List.of(to);
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder plainText(String plainText) {
            this.plainText = plainText;
            return this;
        }

        public Builder htmlText(String htmlText) {
            this.htmlText = htmlText;
            return this;
        }

        public Builder addAttachment(Resource attachment) {
            this.attachments.add(attachment);
            return this;
        }

        public Builder addAttachments(List<Resource> attachments) {
            this.attachments.addAll(attachments);
            return this;
        }

        public Builder addInlineImage(Resource inlineImage) {
            this.inlineImages.add(inlineImage);
            return this;
        }

        public Builder addInlineImages(List<Resource> inlineImages) {
            this.inlineImages.addAll(inlineImages);
            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }
}
