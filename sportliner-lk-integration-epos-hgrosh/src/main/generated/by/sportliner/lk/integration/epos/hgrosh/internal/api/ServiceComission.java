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
import by.sportliner.lk.integration.epos.hgrosh.internal.api.Comission;
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
 * ServiceComission
 */
@JsonPropertyOrder({
  ServiceComission.JSON_PROPERTY_ERIP,
  ServiceComission.JSON_PROPERTY_AGGREGATOR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ServiceComission {
  public static final String JSON_PROPERTY_ERIP = "erip";
  private Comission erip;

  public static final String JSON_PROPERTY_AGGREGATOR = "aggregator";
  private Comission aggregator;

  public ServiceComission() {
  }

  public ServiceComission erip(Comission erip) {
    
    this.erip = erip;
    return this;
  }

   /**
   * Get erip
   * @return erip
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_ERIP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Comission getErip() {
    return erip;
  }


  @JsonProperty(JSON_PROPERTY_ERIP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErip(Comission erip) {
    this.erip = erip;
  }


  public ServiceComission aggregator(Comission aggregator) {
    
    this.aggregator = aggregator;
    return this;
  }

   /**
   * Get aggregator
   * @return aggregator
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_AGGREGATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Comission getAggregator() {
    return aggregator;
  }


  @JsonProperty(JSON_PROPERTY_AGGREGATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAggregator(Comission aggregator) {
    this.aggregator = aggregator;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceComission serviceComission = (ServiceComission) o;
    return Objects.equals(this.erip, serviceComission.erip) &&
        Objects.equals(this.aggregator, serviceComission.aggregator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(erip, aggregator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceComission {\n");
    sb.append("    erip: ").append(toIndentedString(erip)).append("\n");
    sb.append("    aggregator: ").append(toIndentedString(aggregator)).append("\n");
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
