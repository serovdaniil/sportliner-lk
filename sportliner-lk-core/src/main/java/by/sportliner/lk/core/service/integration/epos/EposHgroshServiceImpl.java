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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EposHgroshServiceImpl implements EposHgroshService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EposHgroshServiceImpl.class);

    @Value("${sportliner.lk.intergration.epos.eposBasePath}")
    private String eposBasePath;

    @Value("${sportliner.lk.intergration.epos.eposGrantType}")
    private String eposGrantType;

    @Value("${sportliner.lk.intergration.epos.eposScope}")
    private String eposScope;

    @Value("${sportliner.lk.intergration.epos.eposSportlinerClientId}")
    private String eposSportlinerClientId;

    @Value("${sportliner.lk.intergration.epos.eposMichaleniaClientId}")
    private String eposMichaleniaClientId;

    @Value("${sportliner.lk.intergration.epos.eposSportlinerClientSecret}")
    private String eposSportlinerClientSecret;

    @Value("${sportliner.lk.intergration.epos.eposMichaleniaClientSecret}")
    private String eposMichaleniaClientSecret;

    @Autowired
    private ApplicationSettingsRepository applicationSettingsRepository;

    @Override
    public String createInvoiceFor(Child child) {
        String apiKey = child.getPayingEntity().equals(PayingEntity.MICHALENIA)
            ? getApiKey(eposMichaleniaClientId, eposMichaleniaClientSecret)
            : getApiKey(eposSportlinerClientId, eposSportlinerClientSecret);

        InvoiceApi api = invoiceApi(apiKey);

        Invoice invoice = createInvoiceWithDefaultSettigns(child);

        api.addNewInvoice(null, true, invoice);

        incrementLastInvoiceNumber(child.getPayingEntity());

        return invoice.getNumber();
    }

    @Override
    public String updateInvoiceFor(String number, Transaction transaction) {
        LOGGER.debug("Update invoice for: {}", number);

        String apiKey = transaction.getChild().getPayingEntity().equals(PayingEntity.MICHALENIA)
            ? getApiKey(eposMichaleniaClientId, eposMichaleniaClientSecret)
            : getApiKey(eposSportlinerClientId, eposSportlinerClientSecret);

        InvoiceApi api = invoiceApi(apiKey);

        Invoice invoice = api.getInvoiceInformationByNumber(number);

        LOGGER.debug("Update invoice by id: {}", invoice.getId());

        api.cancelInvoiceToPayById(invoice.getId());

        InvoiceItem invoiceItem = invoice.getItems().get(0);
        invoiceItem.getUnitPrice().setValue(transaction.getInvoiceAmount().doubleValue());

        api.updateInvoiceById(invoice.getId(), false, invoice);

        return invoice.getNumber();
    }

    @Override
    public List<by.sportliner.lk.integration.epos.hgrosh.internal.api.Transaction> findTransactionInvoices(LocalDate date) {
        List<by.sportliner.lk.integration.epos.hgrosh.internal.api.Transaction> transactions = new ArrayList<>();

        for (PayingEntity payingEntity : PayingEntity.values()) {
            String apiKey = payingEntity.equals(PayingEntity.MICHALENIA)
                ? getApiKey(eposMichaleniaClientId, eposMichaleniaClientSecret)
                : getApiKey(eposSportlinerClientId, eposSportlinerClientSecret);

            TransactionRecords transactionRecords = transactionApi(apiKey).getTransactions(null, 1000, null,
                null, date, date.plusDays(1), null, null, null,
                null, Integer.parseInt(payingEntity.getServiceId()), null,
                null, null, null, null
            );

            List<by.sportliner.lk.integration.epos.hgrosh.internal.api.Transaction> payingEntityTransactions =
                transactionRecords.getRecords().stream()
                    .filter(it -> it.getState().equals(TransactionStateEnum.NUMBER_20))
                    .collect(Collectors.toList());

            transactions.addAll(payingEntityTransactions);
        }

        return transactions;
    }

    private String getApiKey(String clientId, String clientSecret) {
        ApiClient apiClient = new ApiClient();

        apiClient.setBasePath(eposBasePath);

        GetApiKey200Response response = new AuthApi(apiClient).getApiKey(
            eposGrantType, clientId, eposScope, clientSecret
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
                .code(1)
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


    private InvoiceApi invoiceApi(String apiKey) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters()
            .stream()
            .filter(it -> it instanceof MappingJackson2HttpMessageConverter)
            .map(MappingJackson2HttpMessageConverter.class::cast)
            .forEach(it -> it.setObjectMapper(createJacksonMapper()));

        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath("https://api-epos.hgrosh.by/public/");
        apiClient.setApiKey(apiKey);
        apiClient.setApiKeyPrefix("Bearer");

        return new InvoiceApi(apiClient);
    }

    private TransactionApi transactionApi(String apiKey) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters()
            .stream()
            .filter(it -> it instanceof MappingJackson2HttpMessageConverter)
            .map(MappingJackson2HttpMessageConverter.class::cast)
            .forEach(it -> it.setObjectMapper(createJacksonMapper()));

        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath("https://api-epos.hgrosh.by/public/");
        apiClient.setApiKey(apiKey);
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
