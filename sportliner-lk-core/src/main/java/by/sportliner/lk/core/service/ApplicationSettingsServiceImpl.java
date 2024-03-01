package by.sportliner.lk.core.service;

import by.sportliner.lk.core.model.ApplicationSettings;
import by.sportliner.lk.core.model.PaymentSettings;
import by.sportliner.lk.core.repository.ApplicationSettingsRepository;
import by.sportliner.lk.core.support.json.json.JacksonObjectMappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;

@Service
public class ApplicationSettingsServiceImpl implements ApplicationSettingsService {

    @Autowired
    private ApplicationSettingsRepository applicationSettingsRepository;

    @Override
    public PaymentSettings getPaymentSettings() {
        ApplicationSettings settings = applicationSettingsRepository.findById("lessons.price")
            .orElseThrow(() -> new IllegalArgumentException("Not found settings"));

        try {
            return JacksonObjectMappers.defaultStrict().readValue(settings.getValue(), PaymentSettings.class);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void updatePaymentSettings(PaymentSettings paymentSettings) {
        ApplicationSettings settings = applicationSettingsRepository.findById("lessons.price")
            .orElseThrow(() -> new IllegalArgumentException("Not found settings"));

        try {
            settings.setValue(JacksonObjectMappers.defaultStrict().writeValueAsString(paymentSettings));
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }

        applicationSettingsRepository.save(settings);
    }
}
