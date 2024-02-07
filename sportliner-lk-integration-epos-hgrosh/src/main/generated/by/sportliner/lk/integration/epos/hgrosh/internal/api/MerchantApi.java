package by.sportliner.lk.integration.epos.hgrosh.internal.api;

import by.sportliner.lk.integration.epos.hgrosh.internal.ApiClient;

import by.sportliner.lk.integration.epos.hgrosh.internal.api.CashBoxRegistrationInfo;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ErrorStatus;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.MerchantPublicInfo;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.OneSignalDeviceRegistrationInfo;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ServiceProvider;
import java.util.UUID;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ZenDeskUserAuthorize;

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
@Component("by.sportliner.lk.integration.epos.hgrosh.internal.api.MerchantApi")
public class MerchantApi {
    private ApiClient apiClient;

    public MerchantApi() {
        this(new ApiClient());
    }

    @Autowired
    public MerchantApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получение публичной информации о РТТ
     * 
     * <p><b>200</b> - Сведения о РТТ.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Идентификатор РТТ. (required)
     * @return MerchantPublicInfo
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MerchantPublicInfo getMerchant(String id) throws RestClientException {
        return getMerchantWithHttpInfo(id).getBody();
    }

    /**
     * Получение публичной информации о РТТ
     * 
     * <p><b>200</b> - Сведения о РТТ.
     * <p><b>400</b> - Неверный запрос.
     * <p><b>401</b> - Неавторизованный запрос.
     * <p><b>403</b> - Недостаточно прав.
     * <p><b>404</b> - Не найдено.
     * <p><b>500</b> - Ошибка на сервере.
     * @param id Идентификатор РТТ. (required)
     * @return ResponseEntity&lt;MerchantPublicInfo&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<MerchantPublicInfo> getMerchantWithHttpInfo(String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getMerchant");
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

        ParameterizedTypeReference<MerchantPublicInfo> localReturnType = new ParameterizedTypeReference<MerchantPublicInfo>() {};
        return apiClient.invokeAPI("/v1/merchant/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Получение информации о конкретном производителе услуг.
     * 
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @return OneSignalDeviceRegistrationInfo
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public OneSignalDeviceRegistrationInfo getServiceProviderDeviceRegisterMerchant() throws RestClientException {
        return getServiceProviderDeviceRegisterMerchantWithHttpInfo().getBody();
    }

    /**
     * Получение информации о конкретном производителе услуг.
     * 
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @return ResponseEntity&lt;OneSignalDeviceRegistrationInfo&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OneSignalDeviceRegistrationInfo> getServiceProviderDeviceRegisterMerchantWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

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

        ParameterizedTypeReference<OneSignalDeviceRegistrationInfo> localReturnType = new ParameterizedTypeReference<OneSignalDeviceRegistrationInfo>() {};
        return apiClient.invokeAPI("/v1/merchant/serviceprovider/device/register", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Получение информации о конкретном производителе услуг.
     * 
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @return ServiceProvider
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ServiceProvider getServiceProviderMerchant() throws RestClientException {
        return getServiceProviderMerchantWithHttpInfo().getBody();
    }

    /**
     * Получение информации о конкретном производителе услуг.
     * 
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @return ResponseEntity&lt;ServiceProvider&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ServiceProvider> getServiceProviderMerchantWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

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

        ParameterizedTypeReference<ServiceProvider> localReturnType = new ParameterizedTypeReference<ServiceProvider>() {};
        return apiClient.invokeAPI("/v1/merchant/serviceprovider", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Получение информации о пользователе для ZenDesk
     * 
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param userToken  (optional)
     * @return ZenDeskUserAuthorize
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ZenDeskUserAuthorize getUserMerchant(UUID userToken) throws RestClientException {
        return getUserMerchantWithHttpInfo(userToken).getBody();
    }

    /**
     * Получение информации о пользователе для ZenDesk
     * 
     * <p><b>200</b> - Success
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param userToken  (optional)
     * @return ResponseEntity&lt;ZenDeskUserAuthorize&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ZenDeskUserAuthorize> getUserMerchantWithHttpInfo(UUID userToken) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        if (userToken != null)
            localVarFormParams.add("user_token", userToken);

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/x-www-form-urlencoded"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "Bearer" };

        ParameterizedTypeReference<ZenDeskUserAuthorize> localReturnType = new ParameterizedTypeReference<ZenDeskUserAuthorize>() {};
        return apiClient.invokeAPI("/v1/merchant/zendesk/user", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Регистрация кассы в OneSignal
     * 
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @param cashBoxRegistrationInfo  (optional)
     * @return ErrorStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ErrorStatus registerServiceProviderDeviceMerchant(CashBoxRegistrationInfo cashBoxRegistrationInfo) throws RestClientException {
        return registerServiceProviderDeviceMerchantWithHttpInfo(cashBoxRegistrationInfo).getBody();
    }

    /**
     * Регистрация кассы в OneSignal
     * 
     * <p><b>200</b> - Success
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>500</b> - Server Error
     * @param cashBoxRegistrationInfo  (optional)
     * @return ResponseEntity&lt;ErrorStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ErrorStatus> registerServiceProviderDeviceMerchantWithHttpInfo(CashBoxRegistrationInfo cashBoxRegistrationInfo) throws RestClientException {
        Object localVarPostBody = cashBoxRegistrationInfo;
        

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

        ParameterizedTypeReference<ErrorStatus> localReturnType = new ParameterizedTypeReference<ErrorStatus>() {};
        return apiClient.invokeAPI("/v1/merchant/serviceprovider/device/register", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
