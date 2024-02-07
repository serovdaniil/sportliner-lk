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
import by.sportliner.lk.integration.epos.hgrosh.internal.api.Address;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.BusinessCard;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.RetailOutletMerchantInfo;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ServiceProviderPublicInfo;
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
 * Отображение РТТ на его \&quot;посадочной\&quot; странице  Содержится сокращенная информация о ПУ и РТТ
 */
@JsonPropertyOrder({
  MerchantPublicInfo.JSON_PROPERTY_SERVICE_PROVIDER,
  MerchantPublicInfo.JSON_PROPERTY_RETAIL_OUTLET_CARD,
  MerchantPublicInfo.JSON_PROPERTY_ADDRESS,
  MerchantPublicInfo.JSON_PROPERTY_MERCHANT_INFO,
  MerchantPublicInfo.JSON_PROPERTY_DESCR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MerchantPublicInfo {
  public static final String JSON_PROPERTY_SERVICE_PROVIDER = "serviceProvider";
  private ServiceProviderPublicInfo serviceProvider;

  public static final String JSON_PROPERTY_RETAIL_OUTLET_CARD = "retailOutletCard";
  private BusinessCard retailOutletCard;

  public static final String JSON_PROPERTY_ADDRESS = "address";
  private Address address;

  public static final String JSON_PROPERTY_MERCHANT_INFO = "merchantInfo";
  private RetailOutletMerchantInfo merchantInfo;

  public static final String JSON_PROPERTY_DESCR = "descr";
  private JsonNullable<String> descr = JsonNullable.<String>undefined();

  public MerchantPublicInfo() {
  }

  public MerchantPublicInfo serviceProvider(ServiceProviderPublicInfo serviceProvider) {
    
    this.serviceProvider = serviceProvider;
    return this;
  }

   /**
   * Get serviceProvider
   * @return serviceProvider
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_SERVICE_PROVIDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ServiceProviderPublicInfo getServiceProvider() {
    return serviceProvider;
  }


  @JsonProperty(JSON_PROPERTY_SERVICE_PROVIDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setServiceProvider(ServiceProviderPublicInfo serviceProvider) {
    this.serviceProvider = serviceProvider;
  }


  public MerchantPublicInfo retailOutletCard(BusinessCard retailOutletCard) {
    
    this.retailOutletCard = retailOutletCard;
    return this;
  }

   /**
   * Get retailOutletCard
   * @return retailOutletCard
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_RETAIL_OUTLET_CARD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BusinessCard getRetailOutletCard() {
    return retailOutletCard;
  }


  @JsonProperty(JSON_PROPERTY_RETAIL_OUTLET_CARD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRetailOutletCard(BusinessCard retailOutletCard) {
    this.retailOutletCard = retailOutletCard;
  }


  public MerchantPublicInfo address(Address address) {
    
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Address getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddress(Address address) {
    this.address = address;
  }


  public MerchantPublicInfo merchantInfo(RetailOutletMerchantInfo merchantInfo) {
    
    this.merchantInfo = merchantInfo;
    return this;
  }

   /**
   * Get merchantInfo
   * @return merchantInfo
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_MERCHANT_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RetailOutletMerchantInfo getMerchantInfo() {
    return merchantInfo;
  }


  @JsonProperty(JSON_PROPERTY_MERCHANT_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchantInfo(RetailOutletMerchantInfo merchantInfo) {
    this.merchantInfo = merchantInfo;
  }


  public MerchantPublicInfo descr(String descr) {
    this.descr = JsonNullable.<String>of(descr);
    
    return this;
  }

   /**
   * Описание РТТ (задается самим ПУ)
   * @return descr
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getDescr() {
        return descr.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getDescr_JsonNullable() {
    return descr;
  }
  
  @JsonProperty(JSON_PROPERTY_DESCR)
  public void setDescr_JsonNullable(JsonNullable<String> descr) {
    this.descr = descr;
  }

  public void setDescr(String descr) {
    this.descr = JsonNullable.<String>of(descr);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MerchantPublicInfo merchantPublicInfo = (MerchantPublicInfo) o;
    return Objects.equals(this.serviceProvider, merchantPublicInfo.serviceProvider) &&
        Objects.equals(this.retailOutletCard, merchantPublicInfo.retailOutletCard) &&
        Objects.equals(this.address, merchantPublicInfo.address) &&
        Objects.equals(this.merchantInfo, merchantPublicInfo.merchantInfo) &&
        equalsNullable(this.descr, merchantPublicInfo.descr);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceProvider, retailOutletCard, address, merchantInfo, hashCodeNullable(descr));
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
    sb.append("class MerchantPublicInfo {\n");
    sb.append("    serviceProvider: ").append(toIndentedString(serviceProvider)).append("\n");
    sb.append("    retailOutletCard: ").append(toIndentedString(retailOutletCard)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    merchantInfo: ").append(toIndentedString(merchantInfo)).append("\n");
    sb.append("    descr: ").append(toIndentedString(descr)).append("\n");
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

