package by.sportliner.lk.integration.epos.hgrosh.internal.api;

import by.sportliner.lk.integration.epos.hgrosh.internal.ApiClient;

import by.sportliner.lk.integration.epos.hgrosh.internal.api.ErrorStatus;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ServiceProvider;

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
@Component("by.sportliner.lk.integration.epos.hgrosh.internal.api.ServiceProviderApi")
public class ServiceProviderApi {
    private ApiClient apiClient;

    public ServiceProviderApi() {
        this(new ApiClient());
    }

    @Autowired
    public ServiceProviderApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Добавление нового поставщика услуг.
     * 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param serviceProvider  (optional)
     * @return ServiceProvider
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) throws RestClientException {
        return addServiceProviderWithHttpInfo(serviceProvider).getBody();
    }

    /**
     * Добавление нового поставщика услуг.
     * 
     * <p><b>201</b> - Created
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>500</b> - Server Error
     * @param serviceProvider  (optional)
     * @return ResponseEntity&lt;ServiceProvider&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ServiceProvider> addServiceProviderWithHttpInfo(ServiceProvider serviceProvider) throws RestClientException {
        Object localVarPostBody = serviceProvider;
        

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

        ParameterizedTypeReference<ServiceProvider> localReturnType = new ParameterizedTypeReference<ServiceProvider>() {};
        return apiClient.invokeAPI("/v1/serviceprovier", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
