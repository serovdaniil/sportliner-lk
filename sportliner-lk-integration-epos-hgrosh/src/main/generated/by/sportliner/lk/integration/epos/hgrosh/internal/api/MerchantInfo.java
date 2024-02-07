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
 * Информация о ПУ в qr-коде.
 */
@JsonPropertyOrder({
  MerchantInfo.JSON_PROPERTY_MERCHANT_NAME,
  MerchantInfo.JSON_PROPERTY_MERCHANT_LOCALITY_NAME,
  MerchantInfo.JSON_PROPERTY_LOCALITY_CODE,
  MerchantInfo.JSON_PROPERTY_IS_MOBILE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MerchantInfo {
  public static final String JSON_PROPERTY_MERCHANT_NAME = "merchantName";
  private JsonNullable<String> merchantName = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_MERCHANT_LOCALITY_NAME = "merchantLocalityName";
  private JsonNullable<String> merchantLocalityName = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_LOCALITY_CODE = "localityCode";
  private JsonNullable<String> localityCode = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_IS_MOBILE = "isMobile";
  private Boolean isMobile;

  public MerchantInfo() {
  }

  public MerchantInfo merchantName(String merchantName) {
    this.merchantName = JsonNullable.<String>of(merchantName);
    
    return this;
  }

   /**
   * Наименование мерчанта в латинице.
   * @return merchantName
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getMerchantName() {
        return merchantName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MERCHANT_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getMerchantName_JsonNullable() {
    return merchantName;
  }
  
  @JsonProperty(JSON_PROPERTY_MERCHANT_NAME)
  public void setMerchantName_JsonNullable(JsonNullable<String> merchantName) {
    this.merchantName = merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = JsonNullable.<String>of(merchantName);
  }


  public MerchantInfo merchantLocalityName(String merchantLocalityName) {
    this.merchantLocalityName = JsonNullable.<String>of(merchantLocalityName);
    
    return this;
  }

   /**
   * Наименование мерчанта в локале.
   * @return merchantLocalityName
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getMerchantLocalityName() {
        return merchantLocalityName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MERCHANT_LOCALITY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getMerchantLocalityName_JsonNullable() {
    return merchantLocalityName;
  }
  
  @JsonProperty(JSON_PROPERTY_MERCHANT_LOCALITY_NAME)
  public void setMerchantLocalityName_JsonNullable(JsonNullable<String> merchantLocalityName) {
    this.merchantLocalityName = merchantLocalityName;
  }

  public void setMerchantLocalityName(String merchantLocalityName) {
    this.merchantLocalityName = JsonNullable.<String>of(merchantLocalityName);
  }


  public MerchantInfo localityCode(String localityCode) {
    this.localityCode = JsonNullable.<String>of(localityCode);
    
    return this;
  }

   /**
   * Наименование локали.
   * @return localityCode
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getLocalityCode() {
        return localityCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCALITY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getLocalityCode_JsonNullable() {
    return localityCode;
  }
  
  @JsonProperty(JSON_PROPERTY_LOCALITY_CODE)
  public void setLocalityCode_JsonNullable(JsonNullable<String> localityCode) {
    this.localityCode = localityCode;
  }

  public void setLocalityCode(String localityCode) {
    this.localityCode = JsonNullable.<String>of(localityCode);
  }


  public MerchantInfo isMobile(Boolean isMobile) {
    
    this.isMobile = isMobile;
    return this;
  }

   /**
   * Признак работы ПУ с мобильным приложением ЕРИП
   * @return isMobile
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_IS_MOBILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isIsMobile() {
    return isMobile;
  }


  @JsonProperty(JSON_PROPERTY_IS_MOBILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIsMobile(Boolean isMobile) {
    this.isMobile = isMobile;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MerchantInfo merchantInfo = (MerchantInfo) o;
    return equalsNullable(this.merchantName, merchantInfo.merchantName) &&
        equalsNullable(this.merchantLocalityName, merchantInfo.merchantLocalityName) &&
        equalsNullable(this.localityCode, merchantInfo.localityCode) &&
        Objects.equals(this.isMobile, merchantInfo.isMobile);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(merchantName), hashCodeNullable(merchantLocalityName), hashCodeNullable(localityCode), isMobile);
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
    sb.append("class MerchantInfo {\n");
    sb.append("    merchantName: ").append(toIndentedString(merchantName)).append("\n");
    sb.append("    merchantLocalityName: ").append(toIndentedString(merchantLocalityName)).append("\n");
    sb.append("    localityCode: ").append(toIndentedString(localityCode)).append("\n");
    sb.append("    isMobile: ").append(toIndentedString(isMobile)).append("\n");
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

