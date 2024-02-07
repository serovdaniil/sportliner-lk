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
 * Дисконт (заполняется одно из двух полей)  Приоритет имеет процент скидки - если он заполнен, то фиксированная скидка не учитывается
 */
@JsonPropertyOrder({
  Discount.JSON_PROPERTY_PERCENT,
  Discount.JSON_PROPERTY_AMOUNT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Discount {
  public static final String JSON_PROPERTY_PERCENT = "percent";
  private JsonNullable<Double> percent = JsonNullable.<Double>undefined();

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private JsonNullable<Double> amount = JsonNullable.<Double>undefined();

  public Discount() {
  }

  public Discount percent(Double percent) {
    this.percent = JsonNullable.<Double>of(percent);
    
    return this;
  }

   /**
   * Дисконт в процентах от суммы (если заполнен)
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


  public Discount amount(Double amount) {
    this.amount = JsonNullable.<Double>of(amount);
    
    return this;
  }

   /**
   * Дисконт в фиксированной сумме (если заполнен)
   * @return amount
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public Double getAmount() {
        return amount.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getAmount_JsonNullable() {
    return amount;
  }
  
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  public void setAmount_JsonNullable(JsonNullable<Double> amount) {
    this.amount = amount;
  }

  public void setAmount(Double amount) {
    this.amount = JsonNullable.<Double>of(amount);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Discount discount = (Discount) o;
    return equalsNullable(this.percent, discount.percent) &&
        equalsNullable(this.amount, discount.amount);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(percent), hashCodeNullable(amount));
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
    sb.append("class Discount {\n");
    sb.append("    percent: ").append(toIndentedString(percent)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

