package by.sportliner.lk.integration.epos.hgrosh.internal.api;

import by.sportliner.lk.integration.epos.hgrosh.internal.ApiClient;

import by.sportliner.lk.integration.epos.hgrosh.internal.api.BiometryPayTypeEnum;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ErrorStatus;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.Invoice;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.InvoiceListItemRecords;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.InvoiceQRCode;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.InvoiceQueryType;
import java.util.UUID;

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
@Component("by.sportliner.lk.integration.epos.hgrosh.internal.api.InvoiceApi")
public class InvoiceApi {
    private ApiClient apiClient;

    public InvoiceApi() {
        this(new ApiClient());
    }

    @Autowired
    public InvoiceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Добавление счета.
     * Добавление счета может быть по нескольким сценариям:     - счет выставляет ПУ, который подключен к сервису E-Pos напрямую,       в этом случае в токене, с которым вызывается данный метод должна быть группа user.sp,       в выставляемом счете будет заменена информация merchantInfo.serviceProviderId на информацию из токена     - счет выставляет сторонний сервис (в нашем случае HutkiGrosh), который действует от имени конечного пользователя       и выставляемый счет, это корзина продуктов, которую необходимо оплатить. Выставляемый таким образом счет не должен содержать       номер счета, так как он будет сформирован автоматически и вернется после выполнения этого метада. Так же этот счет имеет короткое       время жизни, которое определено глобальными настройками сервиса E-Pos. Счета можно выставлять для любого ПУ, существующего в сервисе       и на любой РТТ у данного ПУ. Если ПУ или РТТ заблокированы, то счет не будет выставлен.
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @param motifyBiometryType Вид оплаты при биометрической оплате (optional)
     * @param canPayAtOnce Признак выставления инвойса сразу на оплату (optional, default to false)
     * @param invoice Выставляемый счет. (optional)
     * @return List&lt;Invoice&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Invoice> addNewInvoice(BiometryPayTypeEnum motifyBiometryType, Boolean canPayAtOnce, Invoice invoice) throws RestClientException {
        return addNewInvoiceWithHttpInfo(motifyBiometryType, canPayAtOnce, invoice).getBody();
    }

    /**
     * Добавление счета.
     * Добавление счета может быть по нескольким сценариям:     - счет выставляет ПУ, который подключен к сервису E-Pos напрямую,       в этом случае в токене, с которым вызывается данный метод должна быть группа user.sp,       в выставляемом счете будет заменена информация merchantInfo.serviceProviderId на информацию из токена     - счет выставляет сторонний сервис (в нашем случае HutkiGrosh), который действует от имени конечного пользователя       и выставляемый счет, это корзина продуктов, которую необходимо оплатить. Выставляемый таким образом счет не должен содержать       номер счета, так как он будет сформирован автоматически и вернется после выполнения этого метада. Так же этот счет имеет короткое       время жизни, которое определено глобальными настройками сервиса E-Pos. Счета можно выставлять для любого ПУ, существующего в сервисе       и на любой РТТ у данного ПУ. Если ПУ или РТТ заблокированы, то счет не будет выставлен.
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @param motifyBiometryType Вид оплаты при биометрической оплате (optional)
     * @param canPayAtOnce Признак выставления инвойса сразу на оплату (optional, default to false)
     * @param invoice Выставляемый счет. (optional)
     * @return ResponseEntity&lt;List&lt;Invoice&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Invoice>> addNewInvoiceWithHttpInfo(BiometryPayTypeEnum motifyBiometryType, Boolean canPayAtOnce, Invoice invoice) throws RestClientException {
        Object localVarPostBody = invoice;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "motifyBiometryType", motifyBiometryType));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "canPayAtOnce", canPayAtOnce));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<List<Invoice>> localReturnType = new ParameterizedTypeReference<List<Invoice>>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Отмена возможности оплачивать счет.
     * 
     * <p><b>200</b> - Задание на перевод счета в режим черновика выполнено.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return ErrorStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ErrorStatus cancelInvoiceToPayById(UUID id) throws RestClientException {
        return cancelInvoiceToPayByIdWithHttpInfo(id).getBody();
    }

    /**
     * Отмена возможности оплачивать счет.
     * 
     * <p><b>200</b> - Задание на перевод счета в режим черновика выполнено.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return ResponseEntity&lt;ErrorStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ErrorStatus> cancelInvoiceToPayByIdWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling cancelInvoiceToPayById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<ErrorStatus> localReturnType = new ParameterizedTypeReference<ErrorStatus>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}/cancel", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Запрос повторной нотификации кассы по инвойсу.
     * 
     * <p><b>200</b> - Успешная нотификация.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @param notifyBiometryType Тип оплаты при оплате мобильным приложением (optional)
     * @return ErrorStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ErrorStatus cashBoxNotifyAgainInvoiceById(UUID id, BiometryPayTypeEnum notifyBiometryType) throws RestClientException {
        return cashBoxNotifyAgainInvoiceByIdWithHttpInfo(id, notifyBiometryType).getBody();
    }

    /**
     * Запрос повторной нотификации кассы по инвойсу.
     * 
     * <p><b>200</b> - Успешная нотификация.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @param notifyBiometryType Тип оплаты при оплате мобильным приложением (optional)
     * @return ResponseEntity&lt;ErrorStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ErrorStatus> cashBoxNotifyAgainInvoiceByIdWithHttpInfo(UUID id, BiometryPayTypeEnum notifyBiometryType) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling cashBoxNotifyAgainInvoiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "notifyBiometryType", notifyBiometryType));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<ErrorStatus> localReturnType = new ParameterizedTypeReference<ErrorStatus>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}/cashboxnotify/again", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Запрос нотификации кассы по инвойсу после его отмены.
     * 
     * <p><b>200</b> - Успешная нотификация.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return ErrorStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ErrorStatus cashBoxNotifyCancelInvoiceById(UUID id) throws RestClientException {
        return cashBoxNotifyCancelInvoiceByIdWithHttpInfo(id).getBody();
    }

    /**
     * Запрос нотификации кассы по инвойсу после его отмены.
     * 
     * <p><b>200</b> - Успешная нотификация.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return ResponseEntity&lt;ErrorStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ErrorStatus> cashBoxNotifyCancelInvoiceByIdWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling cashBoxNotifyCancelInvoiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<ErrorStatus> localReturnType = new ParameterizedTypeReference<ErrorStatus>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}/cashboxnotify/cancel", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Удаление счета.
     * Счет можно удалить только если он находится в draft режиме.
     * <p><b>200</b> - Удаление счета завершено успешно, в теле ответа информация об удаленном счете.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Not Found
     * <p><b>423</b> - Счет в режиме оплаты и не подлежит удалению.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return ErrorStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ErrorStatus deleteInvoiceById(UUID id) throws RestClientException {
        return deleteInvoiceByIdWithHttpInfo(id).getBody();
    }

    /**
     * Удаление счета.
     * Счет можно удалить только если он находится в draft режиме.
     * <p><b>200</b> - Удаление счета завершено успешно, в теле ответа информация об удаленном счете.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Not Found
     * <p><b>423</b> - Счет в режиме оплаты и не подлежит удалению.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return ResponseEntity&lt;ErrorStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ErrorStatus> deleteInvoiceByIdWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteInvoiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<ErrorStatus> localReturnType = new ParameterizedTypeReference<ErrorStatus>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Детальная информация о счете.
     * 
     * <p><b>200</b> - Детальная информация о счете.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return Invoice
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Invoice getInvoiceById(UUID id) throws RestClientException {
        return getInvoiceByIdWithHttpInfo(id).getBody();
    }

    /**
     * Детальная информация о счете.
     * 
     * <p><b>200</b> - Детальная информация о счете.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return ResponseEntity&lt;Invoice&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Invoice> getInvoiceByIdWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getInvoiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<Invoice> localReturnType = new ParameterizedTypeReference<Invoice>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Детальная информация о счете.
     * 
     * <p><b>200</b> - Детальная информация о счете.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param number Номер счета в формате SSSSS-RR-N. (required)
     * @return Invoice
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Invoice getInvoiceInformationByNumber(String number) throws RestClientException {
        return getInvoiceInformationByNumberWithHttpInfo(number).getBody();
    }

    /**
     * Детальная информация о счете.
     * 
     * <p><b>200</b> - Детальная информация о счете.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param number Номер счета в формате SSSSS-RR-N. (required)
     * @return ResponseEntity&lt;Invoice&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Invoice> getInvoiceInformationByNumberWithHttpInfo(String number) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'number' is set
        if (number == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'number' when calling getInvoiceInformationByNumber");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("number", number);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<Invoice> localReturnType = new ParameterizedTypeReference<Invoice>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{number}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Получение списка счетов.
     * 
     * <p><b>200</b> - Список счетов, согласно заданных условий.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param beginDate Начальная дата для поиска (optional)
     * @param endDate Конечная дата для поиска (optional)
     * @param skip Количество записей, которые необходимо пропустить. (optional)
     * @param count Количество записй, которые необходимо вернуть. (optional)
     * @param states Необходимые состояния инвойсов (передаются строкой, разделитель точка с запятой) (optional)
     * @param searchString Строка поиска (поиск осуществляется по номеру счета) (optional)
     * @param requestType Тип запроса (по дате создания, по дате оплаты) (optional)
     * @return InvoiceListItemRecords
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InvoiceListItemRecords getInvoices(java.time.LocalDateTime beginDate, java.time.LocalDateTime endDate, Integer skip, Integer count, String states, String searchString, InvoiceQueryType requestType) throws RestClientException {
        return getInvoicesWithHttpInfo(beginDate, endDate, skip, count, states, searchString, requestType).getBody();
    }

    /**
     * Получение списка счетов.
     * 
     * <p><b>200</b> - Список счетов, согласно заданных условий.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param beginDate Начальная дата для поиска (optional)
     * @param endDate Конечная дата для поиска (optional)
     * @param skip Количество записей, которые необходимо пропустить. (optional)
     * @param count Количество записй, которые необходимо вернуть. (optional)
     * @param states Необходимые состояния инвойсов (передаются строкой, разделитель точка с запятой) (optional)
     * @param searchString Строка поиска (поиск осуществляется по номеру счета) (optional)
     * @param requestType Тип запроса (по дате создания, по дате оплаты) (optional)
     * @return ResponseEntity&lt;InvoiceListItemRecords&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<InvoiceListItemRecords> getInvoicesWithHttpInfo(java.time.LocalDateTime beginDate, java.time.LocalDateTime endDate, Integer skip, Integer count, String states, String searchString, InvoiceQueryType requestType) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "beginDate", beginDate));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "endDate", endDate));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "count", count));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "states", states));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "searchString", searchString));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "requestType", requestType));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<InvoiceListItemRecords> localReturnType = new ParameterizedTypeReference<InvoiceListItemRecords>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Получение адреса-ссылки для возможности оплаты заказа картой.
     * 
     * <p><b>200</b> - Запрос выполнен успешно.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Счет не найден.
     * <p><b>500</b> - Ошибка на сервере.
     * @param number Номер счета в формате SSSSS-RR-N. (required)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String payByCardUrlInvoiceByNumber(String number) throws RestClientException {
        return payByCardUrlInvoiceByNumberWithHttpInfo(number).getBody();
    }

    /**
     * Получение адреса-ссылки для возможности оплаты заказа картой.
     * 
     * <p><b>200</b> - Запрос выполнен успешно.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Счет не найден.
     * <p><b>500</b> - Ошибка на сервере.
     * @param number Номер счета в формате SSSSS-RR-N. (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> payByCardUrlInvoiceByNumberWithHttpInfo(String number) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'number' is set
        if (number == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'number' when calling payByCardUrlInvoiceByNumber");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("number", number);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{number}/paybycardurl", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Получение данных для формирования QR-кода.
     * 
     * <p><b>200</b> - Запрос выполнен успешно.
     * <p><b>202</b> - Accepted
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Счет не найден.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @param imgWidth Ширина изображения (optional, default to 174)
     * @param imgHeight Высота изображения (optional, default to 386)
     * @param getImage Признак запроса изображения qr-кода (по умолчанию false) (optional, default to false)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void qrcodeInvoiceById(UUID id, Integer imgWidth, Integer imgHeight, Boolean getImage) throws RestClientException {
        qrcodeInvoiceByIdWithHttpInfo(id, imgWidth, imgHeight, getImage);
    }

    /**
     * Получение данных для формирования QR-кода.
     * 
     * <p><b>200</b> - Запрос выполнен успешно.
     * <p><b>202</b> - Accepted
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Счет не найден.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @param imgWidth Ширина изображения (optional, default to 174)
     * @param imgHeight Высота изображения (optional, default to 386)
     * @param getImage Признак запроса изображения qr-кода (по умолчанию false) (optional, default to false)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> qrcodeInvoiceByIdWithHttpInfo(UUID id, Integer imgWidth, Integer imgHeight, Boolean getImage) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling qrcodeInvoiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "imgWidth", imgWidth));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "imgHeight", imgHeight));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "getImage", getImage));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}/qrcode", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Перевод счета из draft режима в состояние, когда счет можно оплачивать.
     * 
     * <p><b>200</b> - Задание на перевод счета в режим оплаты выполнено.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @param getCurrentDate Параметр, определяющий необходимо ли менять дату активности счета на текущую (optional)
     * @return ErrorStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ErrorStatus sendInvoiceToPayById(UUID id, Boolean getCurrentDate) throws RestClientException {
        return sendInvoiceToPayByIdWithHttpInfo(id, getCurrentDate).getBody();
    }

    /**
     * Перевод счета из draft режима в состояние, когда счет можно оплачивать.
     * 
     * <p><b>200</b> - Задание на перевод счета в режим оплаты выполнено.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @param getCurrentDate Параметр, определяющий необходимо ли менять дату активности счета на текущую (optional)
     * @return ResponseEntity&lt;ErrorStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ErrorStatus> sendInvoiceToPayByIdWithHttpInfo(UUID id, Boolean getCurrentDate) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling sendInvoiceToPayById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "getCurrentDate", getCurrentDate));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<ErrorStatus> localReturnType = new ParameterizedTypeReference<ErrorStatus>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}/send", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Инициирование операции сторно по инвойсу.
     * 
     * <p><b>202</b> - Задание на инициирование сторно по инвойсу принято.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void stornoInvoiceById(UUID id) throws RestClientException {
        stornoInvoiceByIdWithHttpInfo(id);
    }

    /**
     * Инициирование операции сторно по инвойсу.
     * 
     * <p><b>202</b> - Задание на инициирование сторно по инвойсу принято.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> stornoInvoiceByIdWithHttpInfo(UUID id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling stornoInvoiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}/storno", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Редактирование счета.
     * Счет можно изменить только если он находится в draft режиме.
     * <p><b>200</b> - Измененный счет.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Not Found
     * <p><b>423</b> - Счет в режиме оплаты и не подлежит редактированию.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @param notifyServiceProvider Флаг, указывающий о необходимости информирования производителя услуг об изменениях. (optional, default to false)
     * @param invoice Инвойс для редактирования (optional)
     * @return Invoice
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Invoice updateInvoiceById(UUID id, Boolean notifyServiceProvider, Invoice invoice) throws RestClientException {
        return updateInvoiceByIdWithHttpInfo(id, notifyServiceProvider, invoice).getBody();
    }

    /**
     * Редактирование счета.
     * Счет можно изменить только если он находится в draft режиме.
     * <p><b>200</b> - Измененный счет.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Not Found
     * <p><b>423</b> - Счет в режиме оплаты и не подлежит редактированию.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Внутренний идентификатор счета. (required)
     * @param notifyServiceProvider Флаг, указывающий о необходимости информирования производителя услуг об изменениях. (optional, default to false)
     * @param invoice Инвойс для редактирования (optional)
     * @return ResponseEntity&lt;Invoice&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Invoice> updateInvoiceByIdWithHttpInfo(UUID id, Boolean notifyServiceProvider, Invoice invoice) throws RestClientException {
        Object localVarPostBody = invoice;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateInvoiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "notifyServiceProvider", notifyServiceProvider));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<Invoice> localReturnType = new ParameterizedTypeReference<Invoice>() {};
        return apiClient.invokeAPI("/v1/invoicing/invoice/{id}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
