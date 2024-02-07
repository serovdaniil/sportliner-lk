package by.sportliner.lk.integration.epos.hgrosh.internal.api;

import by.sportliner.lk.integration.epos.hgrosh.internal.ApiClient;

import by.sportliner.lk.integration.epos.hgrosh.internal.api.ErrorStatus;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.WebPayParam;

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
@Component("by.sportliner.lk.integration.epos.hgrosh.internal.api.PayApi")
public class PayApi {
    private ApiClient apiClient;

    public PayApi() {
        this(new ApiClient());
    }

    @Autowired
    public PayApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получение формы для оплаты через WebPay
     * 
     * <p><b>200</b> - Запрос выполнен успешно. В ответе находится форма для отображения пользователю
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>404</b> - Счет не найден.
     * <p><b>500</b> - Ошибка на сервере.
     * @param webPayParam Параметры для формирования. (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getFormWebPay(WebPayParam webPayParam) throws RestClientException {
        return getFormWebPayWithHttpInfo(webPayParam).getBody();
    }

    /**
     * Получение формы для оплаты через WebPay
     * 
     * <p><b>200</b> - Запрос выполнен успешно. В ответе находится форма для отображения пользователю
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>404</b> - Счет не найден.
     * <p><b>500</b> - Ошибка на сервере.
     * @param webPayParam Параметры для формирования. (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getFormWebPayWithHttpInfo(WebPayParam webPayParam) throws RestClientException {
        Object localVarPostBody = webPayParam;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/v1/pay/webpay", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
