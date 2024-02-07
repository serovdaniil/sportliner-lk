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
 * Информация по подключению при работе с инвойсами
 */
@JsonPropertyOrder({
  ConnectInfo.JSON_PROPERTY_INVOICE_URL,
  ConnectInfo.JSON_PROPERTY_BIOMETRY_PAY_URL,
  ConnectInfo.JSON_PROPERTY_BIOMETRY_STORNO_URL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ConnectInfo {
  public static final String JSON_PROPERTY_INVOICE_URL = "invoiceUrl";
  private JsonNullable<String> invoiceUrl = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_BIOMETRY_PAY_URL = "biometryPayUrl";
  private JsonNullable<String> biometryPayUrl = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_BIOMETRY_STORNO_URL = "biometryStornoUrl";
  private JsonNullable<String> biometryStornoUrl = JsonNullable.<String>undefined();

  public ConnectInfo() {
  }

  public ConnectInfo invoiceUrl(String invoiceUrl) {
    this.invoiceUrl = JsonNullable.<String>of(invoiceUrl);
    
    return this;
  }

   /**
   * Базовый путь для работы с инвойсами
   * @return invoiceUrl
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getInvoiceUrl() {
        return invoiceUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INVOICE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getInvoiceUrl_JsonNullable() {
    return invoiceUrl;
  }
  
  @JsonProperty(JSON_PROPERTY_INVOICE_URL)
  public void setInvoiceUrl_JsonNullable(JsonNullable<String> invoiceUrl) {
    this.invoiceUrl = invoiceUrl;
  }

  public void setInvoiceUrl(String invoiceUrl) {
    this.invoiceUrl = JsonNullable.<String>of(invoiceUrl);
  }


  public ConnectInfo biometryPayUrl(String biometryPayUrl) {
    this.biometryPayUrl = JsonNullable.<String>of(biometryPayUrl);
    
    return this;
  }

   /**
   * Базовый путь для оплаты биометрией
   * @return biometryPayUrl
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getBiometryPayUrl() {
        return biometryPayUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BIOMETRY_PAY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getBiometryPayUrl_JsonNullable() {
    return biometryPayUrl;
  }
  
  @JsonProperty(JSON_PROPERTY_BIOMETRY_PAY_URL)
  public void setBiometryPayUrl_JsonNullable(JsonNullable<String> biometryPayUrl) {
    this.biometryPayUrl = biometryPayUrl;
  }

  public void setBiometryPayUrl(String biometryPayUrl) {
    this.biometryPayUrl = JsonNullable.<String>of(biometryPayUrl);
  }


  public ConnectInfo biometryStornoUrl(String biometryStornoUrl) {
    this.biometryStornoUrl = JsonNullable.<String>of(biometryStornoUrl);
    
    return this;
  }

   /**
   * Базовый путь для сторно с помощью биометрией
   * @return biometryStornoUrl
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getBiometryStornoUrl() {
        return biometryStornoUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BIOMETRY_STORNO_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getBiometryStornoUrl_JsonNullable() {
    return biometryStornoUrl;
  }
  
  @JsonProperty(JSON_PROPERTY_BIOMETRY_STORNO_URL)
  public void setBiometryStornoUrl_JsonNullable(JsonNullable<String> biometryStornoUrl) {
    this.biometryStornoUrl = biometryStornoUrl;
  }

  public void setBiometryStornoUrl(String biometryStornoUrl) {
    this.biometryStornoUrl = JsonNullable.<String>of(biometryStornoUrl);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectInfo connectInfo = (ConnectInfo) o;
    return equalsNullable(this.invoiceUrl, connectInfo.invoiceUrl) &&
        equalsNullable(this.biometryPayUrl, connectInfo.biometryPayUrl) &&
        equalsNullable(this.biometryStornoUrl, connectInfo.biometryStornoUrl);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(invoiceUrl), hashCodeNullable(biometryPayUrl), hashCodeNullable(biometryStornoUrl));
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
    sb.append("class ConnectInfo {\n");
    sb.append("    invoiceUrl: ").append(toIndentedString(invoiceUrl)).append("\n");
    sb.append("    biometryPayUrl: ").append(toIndentedString(biometryPayUrl)).append("\n");
    sb.append("    biometryStornoUrl: ").append(toIndentedString(biometryStornoUrl)).append("\n");
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

