package by.sportliner.lk.core.service.email;

import by.sportliner.lk.core.model.Child;
import by.sportliner.lk.core.model.TelegramChat;
import by.sportliner.lk.core.model.Transaction;

import java.util.List;

/**
 * Service for sending emails.
 */
public interface EmailService {

    void notifyAboutUnpaidPerLessonInvoice(Child child);

    void notifyAboutNewInvoice(Child child);

    void notifyAboutPaidInvoices(List<Transaction> transactions);

    void notifyAboutUpdatedInvoices(UpdatedInvoicesData data);

    void notifyAboutUnpaidInvoices(List<Transaction> transactions);

    void notifyAboutNewTelegramChat(TelegramChat telegramChat);

    /**
     * Send given email.
     *
     * <p>
     * Please note. In cases when email recipients count is more than configured limit,
     * service will automatically split sending one same with several emails to "partitioned" recipients lists.
     * </p>
     *
     * @param email email to send
     */
    void send(Email email);

}
