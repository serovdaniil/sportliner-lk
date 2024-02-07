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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Ограничения сервиса
 */
@JsonPropertyOrder({
  ServiceRestriction.JSON_PROPERTY_MIN_AMOUNT,
  ServiceRestriction.JSON_PROPERTY_MAX_AMOUNT,
  ServiceRestriction.JSON_PROPERTY_CAN_MAKE_STORNO,
  ServiceRestriction.JSON_PROPERTY_ERIP_STORNO,
  ServiceRestriction.JSON_PROPERTY_AGGREGATOR_STORNO
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ServiceRestriction {
  public static final String JSON_PROPERTY_MIN_AMOUNT = "minAmount";
  private Double minAmount;

  public static final String JSON_PROPERTY_MAX_AMOUNT = "maxAmount";
  private Double maxAmount;

  public static final String JSON_PROPERTY_CAN_MAKE_STORNO = "canMakeStorno";
  private Boolean canMakeStorno;

  public static final String JSON_PROPERTY_ERIP_STORNO = "eripStorno";
  private Boolean eripStorno;

  public static final String JSON_PROPERTY_AGGREGATOR_STORNO = "aggregatorStorno";
  private Boolean aggregatorStorno;

  public ServiceRestriction() {
  }

  @JsonCreator
  public ServiceRestriction(
    @JsonProperty(JSON_PROPERTY_CAN_MAKE_STORNO) Boolean canMakeStorno
  ) {
    this();
    this.canMakeStorno = canMakeStorno;
  }

  public ServiceRestriction minAmount(Double minAmount) {
    
    this.minAmount = minAmount;
    return this;
  }

   /**
   * Минимальная сумма выставления по услуге
   * @return minAmount
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_MIN_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMinAmount() {
    return minAmount;
  }


  @JsonProperty(JSON_PROPERTY_MIN_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMinAmount(Double minAmount) {
    this.minAmount = minAmount;
  }


  public ServiceRestriction maxAmount(Double maxAmount) {
    
    this.maxAmount = maxAmount;
    return this;
  }

   /**
   * Максимальная сумма выставления по услуге
   * @return maxAmount
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_MAX_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMaxAmount() {
    return maxAmount;
  }


  @JsonProperty(JSON_PROPERTY_MAX_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxAmount(Double maxAmount) {
    this.maxAmount = maxAmount;
  }


   /**
   * Определеляет возможность проведения операции сторно по данной услуге
   * @return canMakeStorno
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_CAN_MAKE_STORNO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isCanMakeStorno() {
    return canMakeStorno;
  }




  public ServiceRestriction eripStorno(Boolean eripStorno) {
    
    this.eripStorno = eripStorno;
    return this;
  }

   /**
   * Признак возможности проведения сторно на стороне ЕРИП
   * @return eripStorno
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_ERIP_STORNO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isEripStorno() {
    return eripStorno;
  }


  @JsonProperty(JSON_PROPERTY_ERIP_STORNO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEripStorno(Boolean eripStorno) {
    this.eripStorno = eripStorno;
  }


  public ServiceRestriction aggregatorStorno(Boolean aggregatorStorno) {
    
    this.aggregatorStorno = aggregatorStorno;
    return this;
  }

   /**
   * Признак возможности проведения сторно на стороне агрегатора
   * @return aggregatorStorno
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_AGGREGATOR_STORNO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isAggregatorStorno() {
    return aggregatorStorno;
  }


  @JsonProperty(JSON_PROPERTY_AGGREGATOR_STORNO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAggregatorStorno(Boolean aggregatorStorno) {
    this.aggregatorStorno = aggregatorStorno;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceRestriction serviceRestriction = (ServiceRestriction) o;
    return Objects.equals(this.minAmount, serviceRestriction.minAmount) &&
        Objects.equals(this.maxAmount, serviceRestriction.maxAmount) &&
        Objects.equals(this.canMakeStorno, serviceRestriction.canMakeStorno) &&
        Objects.equals(this.eripStorno, serviceRestriction.eripStorno) &&
        Objects.equals(this.aggregatorStorno, serviceRestriction.aggregatorStorno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minAmount, maxAmount, canMakeStorno, eripStorno, aggregatorStorno);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceRestriction {\n");
    sb.append("    minAmount: ").append(toIndentedString(minAmount)).append("\n");
    sb.append("    maxAmount: ").append(toIndentedString(maxAmount)).append("\n");
    sb.append("    canMakeStorno: ").append(toIndentedString(canMakeStorno)).append("\n");
    sb.append("    eripStorno: ").append(toIndentedString(eripStorno)).append("\n");
    sb.append("    aggregatorStorno: ").append(toIndentedString(aggregatorStorno)).append("\n");
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
