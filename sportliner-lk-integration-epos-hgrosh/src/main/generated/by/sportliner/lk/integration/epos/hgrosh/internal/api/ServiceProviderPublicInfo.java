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
import by.sportliner.lk.integration.epos.hgrosh.internal.api.BusinessCard;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.LegalInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Общая информация о ПУ
 */
@JsonPropertyOrder({
  ServiceProviderPublicInfo.JSON_PROPERTY_LEGAL_INFO,
  ServiceProviderPublicInfo.JSON_PROPERTY_SERVICE_PROVIDER_CARD
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ServiceProviderPublicInfo {
  public static final String JSON_PROPERTY_LEGAL_INFO = "legalInfo";
  private LegalInfo legalInfo;

  public static final String JSON_PROPERTY_SERVICE_PROVIDER_CARD = "serviceProviderCard";
  private BusinessCard serviceProviderCard;

  public ServiceProviderPublicInfo() {
  }

  public ServiceProviderPublicInfo legalInfo(LegalInfo legalInfo) {
    
    this.legalInfo = legalInfo;
    return this;
  }

   /**
   * Get legalInfo
   * @return legalInfo
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_LEGAL_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LegalInfo getLegalInfo() {
    return legalInfo;
  }


  @JsonProperty(JSON_PROPERTY_LEGAL_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLegalInfo(LegalInfo legalInfo) {
    this.legalInfo = legalInfo;
  }


  public ServiceProviderPublicInfo serviceProviderCard(BusinessCard serviceProviderCard) {
    
    this.serviceProviderCard = serviceProviderCard;
    return this;
  }

   /**
   * Get serviceProviderCard
   * @return serviceProviderCard
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_SERVICE_PROVIDER_CARD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BusinessCard getServiceProviderCard() {
    return serviceProviderCard;
  }


  @JsonProperty(JSON_PROPERTY_SERVICE_PROVIDER_CARD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setServiceProviderCard(BusinessCard serviceProviderCard) {
    this.serviceProviderCard = serviceProviderCard;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceProviderPublicInfo serviceProviderPublicInfo = (ServiceProviderPublicInfo) o;
    return Objects.equals(this.legalInfo, serviceProviderPublicInfo.legalInfo) &&
        Objects.equals(this.serviceProviderCard, serviceProviderPublicInfo.serviceProviderCard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(legalInfo, serviceProviderCard);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceProviderPublicInfo {\n");
    sb.append("    legalInfo: ").append(toIndentedString(legalInfo)).append("\n");
    sb.append("    serviceProviderCard: ").append(toIndentedString(serviceProviderCard)).append("\n");
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

