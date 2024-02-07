package by.sportliner.lk.integration.epos.hgrosh.internal.api;

import by.sportliner.lk.integration.epos.hgrosh.internal.ApiClient;

import by.sportliner.lk.integration.epos.hgrosh.internal.api.ErrorStatus;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.GetApiKey200Response;

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
@Component("by.sportliner.lk.integration.epos.hgrosh.internal.api.AuthApi")
public class AuthApi {
    private ApiClient apiClient;

    public AuthApi() {
        this(new ApiClient());
    }

    @Autowired
    public AuthApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получение ключа API.
     * 
     * <p><b>200</b> - Auth
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param grantType  (optional)
     * @param clientId  (optional)
     * @param scope  (optional)
     * @param clientSecret  (optional)
     * @return GetApiKey200Response
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetApiKey200Response getApiKey(String grantType, String clientId, String scope, String clientSecret) throws RestClientException {
        return getApiKeyWithHttpInfo(grantType, clientId, scope, clientSecret).getBody();
    }

    /**
     * Получение ключа API.
     * 
     * <p><b>200</b> - Auth
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param grantType  (optional)
     * @param clientId  (optional)
     * @param scope  (optional)
     * @param clientSecret  (optional)
     * @return ResponseEntity&lt;GetApiKey200Response&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetApiKey200Response> getApiKeyWithHttpInfo(String grantType, String clientId, String scope, String clientSecret) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        if (grantType != null)
            localVarFormParams.add("grant_type", grantType);
        if (clientId != null)
            localVarFormParams.add("client_id", clientId);
        if (scope != null)
            localVarFormParams.add("scope", scope);
        if (clientSecret != null)
            localVarFormParams.add("client_secret", clientSecret);

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/x-www-form-urlencoded"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<GetApiKey200Response> localReturnType = new ParameterizedTypeReference<GetApiKey200Response>() {};
        return apiClient.invokeAPI("/connect/token", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
