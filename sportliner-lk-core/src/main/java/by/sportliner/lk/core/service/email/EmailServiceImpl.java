package by.sportliner.lk.core.service.email;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.TelegramChat;
import by.sportliner.lk.core.model.Transaction;
import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.service.UserAccountService;
import by.sportliner.lk.core.support.html.HtmlBuilders;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    private final JavaMailSender sender;

    private final String from;

    private final int recipientsLimit;

    private UserAccountService userAccountService;

    public EmailServiceImpl(JavaMailSender sender, String from,
                            int recipientsLimit, UserAccountService userAccountService) {
        this.sender = sender;
        this.from = from;
        this.recipientsLimit = recipientsLimit;
        this.userAccountService = userAccountService;
    }

    @Override
    public void notifyAboutUnpaidPerLessonInvoice(Child child) {
        String html = HtmlBuilders.fromTemplate()
            .template(new ClassPathResource("email/notify-unpaid-per-lesson-invoice.html.ftl"))
            .variable("data", child)
            .toHtml();

        List<UserAccount> recipients = userAccountService.findAllAdmin();

        Email email = new Email.Builder()
            .to(recipients.stream()
                .map(UserAccount::getEmail)
                .collect(Collectors.toList())
            )
            .subject("Sportliner LK. Неоплачено занятие у ребенка с типом \"Оплата за занятие\"")
            .htmlText(html)
            .build();

        send(email);
    }

    @Override
    public void notifyAboutPaidInvoices(List<Transaction> transactions) {
        BigDecimal total = transactions.stream()
            .map(Transaction::getInvoiceAmount)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);

        String html = HtmlBuilders.fromTemplate()
            .template(new ClassPathResource("email/notify-paid-invoices.html.ftl"))
            .variable("data", transactions)
            .variable("total", total)
            .toHtml();

        List<String> recipients = List.of("mihalenya80@mail.ru", "daniils3rov@yandex.by");

        Email email = buildEmail("Sportliner LK. Ежедневный финансовый отчет поступления оплат.", recipients, html);

        send(email);
    }

    @Override
    public void notifyAboutNewInvoice(Child child) {
        String html = extractHtmlFromFile("notify-new-invoice.html.ftl", child);

        List<String> recipients = getAdminsEmail();

        Email email = buildEmail("Sportliner LK. Создан новый счет для ребенка", recipients, html);

        send(email);
    }

    @Override
    public void notifyAboutUpdatedInvoices(UpdatedInvoicesData data) {
        String html = extractHtmlFromFile("notify-updated-invoices.html.ftl", data);

        List<String> recipients = data.getRecipients();

        Email email = buildEmail(
            "Sportliner LK. Финансовый отчет после автоматического обновления счетов.", recipients, html
        );

        send(email);
    }

    @Override
    public void notifyAboutUnpaidInvoices(List<Transaction> transactions) {
        String html = extractHtmlFromFile("notify-unpaid-invoices.html.ftl", transactions);

        List<String> recipients = getAdminsEmail();

        Email email = buildEmail("Sportliner LK. Отчет о неоплаченных счетах", recipients, html);

        send(email);
    }

    @Override
    public void notifyAboutNewTelegramChat(TelegramChat telegramChat) {
        String html = extractHtmlFromFile("notify-telegram-chat.html.ftl", telegramChat);

        List<String> recipients = getAdminsEmail();

        Email email = buildEmail("Sportliner LK. Telegram-бот новая заявка.", recipients, html);

        send(email);
    }

    @Override
    public void send(Email email) {
        Objects.requireNonNull(email, "email");

        doSend(email);
    }

    private Email buildEmail(String subject, List<String> recipients, String html) {
        return new Email.Builder()
            .to(recipients)
            .subject(subject)
            .htmlText(html)
            .build();
    }

    private void doSend(Email email) {
        for (List<String> to : partitionList(email.getTo(), recipientsLimit)) {
            email = Email.Builder.copyOf(email).to(to).build();

            LOGGER.debug("Sending email: subject = '{}', to = {}", email.getSubject(), email.getTo());
            sender.send(createMimeMessage(email));
            LOGGER.debug("Done sending email: subject = '{}', to = {}", email.getSubject(), email.getTo());
        }

    }

    private MimeMessage createMimeMessage(Email email) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(email.getTo().toArray(String[]::new));
            helper.setSubject(email.getSubject());

            String htmlText = email.getHtmlText();
            String plainText = email.getPlainText();

            if (htmlText != null && plainText != null) {
                helper.setText(plainText, htmlText);
            } else if (htmlText != null) {
                helper.setText(htmlText, true);
            } else if (plainText != null) {
                helper.setText(plainText, false);
            }

            for (Resource inlineImage : email.getInlineImages()) {
                helper.addInline(Objects.requireNonNull(inlineImage.getFilename()), inlineImage);
            }

            for (Resource attachment : email.getAttachments()) {
                helper.addAttachment(Objects.requireNonNull(attachment.getFilename()), attachment);
            }

            return message;

        } catch (MessagingException e) {
            throw new RuntimeException("Error while build MimeMessage", e);
        }
    }

    private static <T> List<List<T>> partitionList(List<T> list, int chunkSize) {
        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i += chunkSize) {
            result.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }

        return result;
    }

    private String extractHtmlFromFile(String fileName, Object data) {
        String filePath = "email/${fileName}".replace("${fileName}", fileName);

        return HtmlBuilders.fromTemplate()
            .template(new ClassPathResource(filePath))
            .variable("data", data)
            .toHtml();
    }

    private List<String> getAdminsEmail() {
        return userAccountService.findAllAdmin().stream()
            .map(UserAccount::getEmail)
            .collect(Collectors.toList());
    }

}
