package by.sportliner.lk.integration.epos.hgrosh.internal.api;

import by.sportliner.lk.integration.epos.hgrosh.internal.ApiClient;

import by.sportliner.lk.integration.epos.hgrosh.internal.api.ErrorStatus;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionDateType;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionRecords;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@Component("by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionApi")
public class TransactionApi {
    private ApiClient apiClient;

    public TransactionApi() {
        this(new ApiClient());
    }

    @Autowired
    public TransactionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получение списка транзакций по параметрам
     * 
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @param skip Количество записей, которые необходимо пропустить. (optional)
     * @param count Количество записй, которые необходимо вернуть. (optional)
     * @param transactionStatuses Статус транзакции (optional)
     * @param dateType Тип даты для выборки (optional)
     * @param beginDateUTC Начальная дата выборки (optional)
     * @param endDateUTC Конечная дата выборки (optional)
     * @param eripTransactionId Идентификатор транзакции ЕРИП (optional)
     * @param aggregatorCode Агрегатор для поиска (optional)
     * @param serviceProviderUNP УНП ПУ для поиска (optional)
     * @param serviceProviderCode Код ПУ (optional)
     * @param serviceId Код сервиса (optional)
     * @param retailOutletId Код РТТ (optional)
     * @param serviceProviderName Наименование ПУ для поиска (или часть наименования) (optional)
     * @param clientName Наименование покупателя для поиска (или его часть) (optional)
     * @param clientAddress Адрес клиента для поиска (или его часть) (optional)
     * @param show480ExcludeOnly  (optional, default to false)
     * @return TransactionRecords
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TransactionRecords getTransactions(Integer skip, Integer count, String transactionStatuses, TransactionDateType dateType, java.time.LocalDate beginDateUTC, java.time.LocalDate endDateUTC, Long eripTransactionId, Integer aggregatorCode, String serviceProviderUNP, Long serviceProviderCode, Integer serviceId, Integer retailOutletId, String serviceProviderName, String clientName, String clientAddress, Boolean show480ExcludeOnly) throws RestClientException {
        return getTransactionsWithHttpInfo(skip, count, transactionStatuses, dateType, beginDateUTC, endDateUTC, eripTransactionId, aggregatorCode, serviceProviderUNP, serviceProviderCode, serviceId, retailOutletId, serviceProviderName, clientName, clientAddress, show480ExcludeOnly).getBody();
    }

    /**
     * Получение списка транзакций по параметрам
     * 
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @param skip Количество записей, которые необходимо пропустить. (optional)
     * @param count Количество записй, которые необходимо вернуть. (optional)
     * @param transactionStatuses Статус транзакции (optional)
     * @param dateType Тип даты для выборки (optional)
     * @param beginDateUTC Начальная дата выборки (optional)
     * @param endDateUTC Конечная дата выборки (optional)
     * @param eripTransactionId Идентификатор транзакции ЕРИП (optional)
     * @param aggregatorCode Агрегатор для поиска (optional)
     * @param serviceProviderUNP УНП ПУ для поиска (optional)
     * @param serviceProviderCode Код ПУ (optional)
     * @param serviceId Код сервиса (optional)
     * @param retailOutletId Код РТТ (optional)
     * @param serviceProviderName Наименование ПУ для поиска (или часть наименования) (optional)
     * @param clientName Наименование покупателя для поиска (или его часть) (optional)
     * @param clientAddress Адрес клиента для поиска (или его часть) (optional)
     * @param show480ExcludeOnly  (optional, default to false)
     * @return ResponseEntity&lt;TransactionRecords&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TransactionRecords> getTransactionsWithHttpInfo(Integer skip, Integer count, String transactionStatuses, TransactionDateType dateType, java.time.LocalDate beginDateUTC, java.time.LocalDate endDateUTC, Long eripTransactionId, Integer aggregatorCode, String serviceProviderUNP, Long serviceProviderCode, Integer serviceId, Integer retailOutletId, String serviceProviderName, String clientName, String clientAddress, Boolean show480ExcludeOnly) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "count", count));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "transactionStatuses", transactionStatuses));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "dateType", dateType));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "beginDateUTC", beginDateUTC));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "endDateUTC", endDateUTC));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "eripTransactionId", eripTransactionId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "aggregatorCode", aggregatorCode));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "serviceProviderUNP", serviceProviderUNP));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "serviceProviderCode", serviceProviderCode));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "serviceId", serviceId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "retailOutletId", retailOutletId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "serviceProviderName", serviceProviderName));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "clientName", clientName));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "clientAddress", clientAddress));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "show480ExcludeOnly", show480ExcludeOnly));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<TransactionRecords> localReturnType = new ParameterizedTypeReference<TransactionRecords>() {};
        return apiClient.invokeAPI("/v1/transaction", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
