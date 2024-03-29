/*
 * EPOS public API
 * **Public API сервиса E-POS**  For mode details refer to: * [ Website ](https://www.e-pos.by) * [API Docs](https://api-epos.hgrosh.by/public/swagger/index.html)
 *
 * The version of the OpenAPI document: v1
 * Contact: support-api@epos.by
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package by.sportliner.lk.integration.epos.hgrosh.internal.api;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Данные для интеграции
 */
@JsonPropertyOrder({
  ServiceProviderIII.JSON_PROPERTY_CLIENT_ID,
  ServiceProviderIII.JSON_PROPERTY_CLIENT_SECRET,
  ServiceProviderIII.JSON_PROPERTY_PREFIX_ID,
  ServiceProviderIII.JSON_PROPERTY_ENABLE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ServiceProviderIII {
  public static final String JSON_PROPERTY_CLIENT_ID = "clientId";
  private JsonNullable<String> clientId = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_CLIENT_SECRET = "clientSecret";
  private JsonNullable<String> clientSecret = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_PREFIX_ID = "prefixId";
  private JsonNullable<String> prefixId = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_ENABLE = "enable";
  private Boolean enable;

  public ServiceProviderIII() {
  }

  public ServiceProviderIII clientId(String clientId) {
    this.clientId = JsonNullable.<String>of(clientId);
    
    return this;
  }

   /**
   * Идентификатор агрегатора
   * @return clientId
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getClientId() {
        return clientId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getClientId_JsonNullable() {
    return clientId;
  }
  
  @JsonProperty(JSON_PROPERTY_CLIENT_ID)
  public void setClientId_JsonNullable(JsonNullable<String> clientId) {
    this.clientId = clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = JsonNullable.<String>of(clientId);
  }


  public ServiceProviderIII clientSecret(String clientSecret) {
    this.clientSecret = JsonNullable.<String>of(clientSecret);
    
    return this;
  }

   /**
   * \&quot;Секрет\&quot; ПУ для доступа на сервер идентификации
   * @return clientSecret
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getClientSecret() {
        return clientSecret.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_SECRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getClientSecret_JsonNullable() {
    return clientSecret;
  }
  
  @JsonProperty(JSON_PROPERTY_CLIENT_SECRET)
  public void setClientSecret_JsonNullable(JsonNullable<String> clientSecret) {
    this.clientSecret = clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = JsonNullable.<String>of(clientSecret);
  }


  public ServiceProviderIII prefixId(String prefixId) {
    this.prefixId = JsonNullable.<String>of(prefixId);
    
    return this;
  }

   /**
   * Префикс идентификатора агрегатора на сервере идентификации
   * @return prefixId
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getPrefixId() {
        return prefixId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PREFIX_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPrefixId_JsonNullable() {
    return prefixId;
  }
  
  @JsonProperty(JSON_PROPERTY_PREFIX_ID)
  public void setPrefixId_JsonNullable(JsonNullable<String> prefixId) {
    this.prefixId = prefixId;
  }

  public void setPrefixId(String prefixId) {
    this.prefixId = JsonNullable.<String>of(prefixId);
  }


  public ServiceProviderIII enable(Boolean enable) {
    
    this.enable = enable;
    return this;
  }

   /**
   * Признак активности агрегатора на сервере идентификации
   * @return enable
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_ENABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isEnable() {
    return enable;
  }


  @JsonProperty(JSON_PROPERTY_ENABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnable(Boolean enable) {
    this.enable = enable;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceProviderIII serviceProviderIII = (ServiceProviderIII) o;
    return equalsNullable(this.clientId, serviceProviderIII.clientId) &&
        equalsNullable(this.clientSecret, serviceProviderIII.clientSecret) &&
        equalsNullable(this.prefixId, serviceProviderIII.prefixId) &&
        Objects.equals(this.enable, serviceProviderIII.enable);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(clientId), hashCodeNullable(clientSecret), hashCodeNullable(prefixId), enable);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceProviderIII {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString(clientSecret)).append("\n");
    sb.append("    prefixId: ").append(toIndentedString(prefixId)).append("\n");
    sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

