package by.sportliner.lk.core.service.integration.epos;

import by.sportliner.lk.core.model.Transaction;
import by.sportliner.lk.core.model.*;
import by.sportliner.lk.core.repository.ApplicationSettingsRepository;
import by.sportliner.lk.integration.epos.hgrosh.internal.ApiClient;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EposHgroshServiceImpl implements EposHgroshService {

    @Autowired
    private ApplicationSettingsRepository applicationSettingsRepository;

    @Override
    public String createInvoiceFor(Child child) {
        InvoiceApi api = invoiceApi();

        Invoice invoice = createInvoiceWithDefaultSettigns(child);

        api.addNewInvoice(null, true, invoice);

        incrementLastInvoiceNumber(child.getPayingEntity());

        return invoice.getNumber();
    }

    @Override
    public String updateInvoiceFor(String number, Transaction transaction) {
        InvoiceApi api = invoiceApi();

        Invoice invoice = api.getInvoiceInformationByNumber(number);

        api.cancelInvoiceToPayById(invoice.getId());

        InvoiceItem invoiceItem = invoice.getItems().get(0);
        invoiceItem.getUnitPrice().setValue(transaction.getInvoiceAmount().doubleValue());

        api.updateInvoiceById(invoice.getId(), false, invoice);

        return invoice.getNumber();
    }

    @Override
    public TransactionRecords findTransactionInvoices(LocalDate date) {
        return transactionApi().getTransactions(null, 1000, null, null,
            date, date.plusDays(1), null,
            null, null, null, null, null,
            null, null, null, null
        );
    }

    private String getApiKey() {
        ApiClient apiClient = new ApiClient();

        apiClient.setBasePath("https://iii.by");

        GetApiKey200Response response = new AuthApi(apiClient).getApiKey(
            "client_credentials", "193218544", "epos.public.invoice", "fd33815a-8021-4fda-bba3-f5ee500e903f"
        );

        return response.getAccessToken();
    }

    private Invoice createInvoiceWithDefaultSettigns(Child child) {
        Invoice invoice = new Invoice();

        invoice.currency("933");
        invoice.number(getInvoiceNumber(child.getPayingEntity()));
        invoice.billingInfo(new BillingInfo()
            .contact(new Person()
                .firstName(child.getFirstName())
                .lastName(child.getLastName())
                .middleName(child.getPatronymic())
            )
            .email(child.getParent().getEmail())
            .phone(new Phone()
                .countryCode("+375")
                .nationalNumber(child.getParent().getPhone().substring(4))
            )
        );
        invoice.setMerchantInfo(new ServiceProviderInfo()
            .serviceProviderId(Long.parseLong(child.getPayingEntity().getServiceId()))
            .serviceId(Long.parseLong(child.getPayingEntity().getServiceId()))
            .retailOutlet(new RetailOutlet()
                .code(Integer.parseInt(child.getPayingEntity().getServiceId()))
            )
        );
        invoice.items(generateInvoiceItems(child));
        invoice.paymentRules(new PaymentRules()
            .isTariff(true)
        );
        invoice.dateInAirUTC(LocalDateTime.now().minusHours(3));
        invoice.paymentDueTerms(new PaymentDueTerms()
            .termsDay(10)
        );

        return invoice;
    }

    private String getInvoiceNumber(PayingEntity payingEntity) {
        ApplicationSettings settings = applicationSettingsRepository.findById(payingEntity.getId())
            .orElseThrow(() -> new IllegalArgumentException("Not found application settings with id: " + payingEntity.getId()));

        return settings.getValue();
    }

    private List<InvoiceItem> generateInvoiceItems(Child child) {
        InvoiceItem invoiceItem = new InvoiceItem()
            .name("Физкультурнооздоровительные услуги")
            .unitPrice(new Amount()
                .value(child.getPaymentType().equals(PaymentType.PER_LESSON) ? 16.5 : 0)
            )
            .measure("")
            .discount(new Discount());

        return List.of(invoiceItem);
    }

    private void incrementLastInvoiceNumber(PayingEntity payingEntity) {
        ApplicationSettings settings = applicationSettingsRepository.findById(payingEntity.getId())
            .orElseThrow(() -> new IllegalArgumentException("Not found application settings with id: " + payingEntity.getId()));
        int newIndex = Integer.parseInt(settings.getValue()) + 1;

        settings.setValue(String.valueOf(newIndex));

        applicationSettingsRepository.save(settings);
    }


    private InvoiceApi invoiceApi() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters()
            .stream()
            .filter(it -> it instanceof MappingJackson2HttpMessageConverter)
            .map(MappingJackson2HttpMessageConverter.class::cast)
            .forEach(it -> it.setObjectMapper(createJacksonMapper()));

        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath("https://api-epos.hgrosh.by/public/");
        apiClient.setApiKey(getApiKey());
        apiClient.setApiKeyPrefix("Bearer");

        return new InvoiceApi(apiClient);
    }

    private TransactionApi transactionApi() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters()
            .stream()
            .filter(it -> it instanceof MappingJackson2HttpMessageConverter)
            .map(MappingJackson2HttpMessageConverter.class::cast)
            .forEach(it -> it.setObjectMapper(createJacksonMapper()));

        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath("https://api-epos.hgrosh.by/public/");
        apiClient.setApiKey(getApiKey());
        apiClient.setApiKeyPrefix("Bearer");

        return new TransactionApi(apiClient);
    }

    private ObjectMapper createJacksonMapper() {
        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json()
            .serializationInclusion(JsonInclude.Include.NON_NULL) // API server doesn't like "null" values

            .serializerByType(LocalDateTime.class, new LocalDateTimeJsonConverter.Serializer())
            .deserializerByType(LocalDateTime.class, new LocalDateTimeJsonConverter.Deserializer())

            .build();

        mapper.registerModule(new JsonNullableModule());

        return mapper;
    }

    private static class LocalDateTimeJsonConverter {

        public static class Serializer extends JsonSerializer<LocalDateTime> {
            @Override
            public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString(value.toString());
            }
        }

        public static class Deserializer extends JsonDeserializer<LocalDateTime> {
            @Override
            public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return LocalDateTime.parse(p.getText());
            }
        }

    }

}
