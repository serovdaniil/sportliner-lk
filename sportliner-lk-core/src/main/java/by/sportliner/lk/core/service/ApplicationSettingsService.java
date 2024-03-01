package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.PaymentSettings;

public interface ApplicationSettingsService {

    PaymentSettings getPaymentSettings();

    void updatePaymentSettings(PaymentSettings paymentSettings);

}
