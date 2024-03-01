package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.PaymentSettings;
import by.sportliner.lk.core.service.ApplicationSettingsService;
import by.sportliner.lk.endpoint.api.PaymentSettingsDto;
import by.sportliner.lk.endpoint.api.PriceItemDto;
import by.sportliner.lk.endpoint.api.PriceItemTypeDto;
import by.sportliner.lk.endpoint.api.SettingsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class SettingsApiController implements SettingsApi {

    @Autowired
    private ApplicationSettingsService applicationSettingsService;

    @Override
    public ResponseEntity<PaymentSettingsDto> getPaymentSettings() {
        PaymentSettings paymentSettings = applicationSettingsService.getPaymentSettings();

        Function<Map.Entry<PaymentSettings.Type, PaymentSettings.PriceItem>, PriceItemDto> convert =
            entry -> new PriceItemDto()
                .type(PriceItemTypeDto.valueOf(entry.getKey().name()))
                .normalPrice(entry.getValue().normalPrice())
                .benefitsPrice(entry.getValue().benefitsPrice());

        return ResponseEntity.ok(new PaymentSettingsDto()
            .usePrevPrice(paymentSettings.isUsePrevPrice())
            .currentPrice(paymentSettings.getCurrentPrice().entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getCountLessons()))
                .map(convert)
                .collect(Collectors.toList())
            )
            .prevPrice(paymentSettings.getPrevPrice().entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getCountLessons()))
                .map(convert)
                .collect(Collectors.toList())
            )
        );
    }

    @Override
    public ResponseEntity<Void> updatePaymentSettings(PaymentSettingsDto paymentSettingsDto) {
        PaymentSettings paymentSettings = new PaymentSettings();

        paymentSettings.setUsePrevPrice(paymentSettings.isUsePrevPrice());
        paymentSettings.setCurrentPrice(paymentSettingsDto.getCurrentPrice().stream()
            .collect(Collectors.toMap(
                it -> PaymentSettings.Type.valueOf(it.getType().name()),
                it -> new PaymentSettings.PriceItem(it.getNormalPrice(), it.getBenefitsPrice())
            ))
        );
        paymentSettings.setPrevPrice(paymentSettingsDto.getPrevPrice().stream()
            .collect(Collectors.toMap(
                it -> PaymentSettings.Type.valueOf(it.getType().name()),
                it -> new PaymentSettings.PriceItem(it.getNormalPrice(), it.getBenefitsPrice())
            ))
        );

        applicationSettingsService.updatePaymentSettings(paymentSettings);

        return ResponseEntity.ok().build();
    }

}
