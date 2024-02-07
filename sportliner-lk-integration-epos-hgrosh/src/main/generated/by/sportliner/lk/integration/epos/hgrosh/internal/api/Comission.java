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
 * Comission
 */
@JsonPropertyOrder({
  Comission.JSON_PROPERTY_PERCENT,
  Comission.JSON_PROPERTY_MIN_AMOUNT,
  Comission.JSON_PROPERTY_MAX_AMOUNT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Comission {
  public static final String JSON_PROPERTY_PERCENT = "percent";
  private JsonNullable<Double> percent = JsonNullable.<Double>undefined();

  public static final String JSON_PROPERTY_MIN_AMOUNT = "minAmount";
  private JsonNullable<Double> minAmount = JsonNullable.<Double>undefined();

  public static final String JSON_PROPERTY_MAX_AMOUNT = "maxAmount";
  private JsonNullable<Double> maxAmount = JsonNullable.<Double>undefined();

  public Comission() {
  }

  public Comission percent(Double percent) {
    this.percent = JsonNullable.<Double>of(percent);
    
    return this;
  }

   /**
   * Get percent
   * @return percent
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public Double getPercent() {
        return percent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PERCENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getPercent_JsonNullable() {
    return percent;
  }
  
  @JsonProperty(JSON_PROPERTY_PERCENT)
  public void setPercent_JsonNullable(JsonNullable<Double> percent) {
    this.percent = percent;
  }

  public void setPercent(Double percent) {
    this.percent = JsonNullable.<Double>of(percent);
  }


  public Comission minAmount(Double minAmount) {
    this.minAmount = JsonNullable.<Double>of(minAmount);
    
    return this;
  }

   /**
   * Get minAmount
   * @return minAmount
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public Double getMinAmount() {
        return minAmount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MIN_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getMinAmount_JsonNullable() {
    return minAmount;
  }
  
  @JsonProperty(JSON_PROPERTY_MIN_AMOUNT)
  public void setMinAmount_JsonNullable(JsonNullable<Double> minAmount) {
    this.minAmount = minAmount;
  }

  public void setMinAmount(Double minAmount) {
    this.minAmount = JsonNullable.<Double>of(minAmount);
  }


  public Comission maxAmount(Double maxAmount) {
    this.maxAmount = JsonNullable.<Double>of(maxAmount);
    
    return this;
  }

   /**
   * Get maxAmount
   * @return maxAmount
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public Double getMaxAmount() {
        return maxAmount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getMaxAmount_JsonNullable() {
    return maxAmount;
  }
  
  @JsonProperty(JSON_PROPERTY_MAX_AMOUNT)
  public void setMaxAmount_JsonNullable(JsonNullable<Double> maxAmount) {
    this.maxAmount = maxAmount;
  }

  public void setMaxAmount(Double maxAmount) {
    this.maxAmount = JsonNullable.<Double>of(maxAmount);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comission comission = (Comission) o;
    return equalsNullable(this.percent, comission.percent) &&
        equalsNullable(this.minAmount, comission.minAmount) &&
        equalsNullable(this.maxAmount, comission.maxAmount);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(percent), hashCodeNullable(minAmount), hashCodeNullable(maxAmount));
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
    sb.append("class Comission {\n");
    sb.append("    percent: ").append(toIndentedString(percent)).append("\n");
    sb.append("    minAmount: ").append(toIndentedString(minAmount)).append("\n");
    sb.append("    maxAmount: ").append(toIndentedString(maxAmount)).append("\n");
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

