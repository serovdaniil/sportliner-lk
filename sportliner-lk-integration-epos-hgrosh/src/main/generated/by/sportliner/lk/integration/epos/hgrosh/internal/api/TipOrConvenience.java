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
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TipOrConvenienceEnum;
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
 * Тип комиссии за операцию или запрос у плательщика на extrapay(чаевые торговцу).
 */
@JsonPropertyOrder({
  TipOrConvenience.JSON_PROPERTY_TYPE,
  TipOrConvenience.JSON_PROPERTY_FLAT_FEE,
  TipOrConvenience.JSON_PROPERTY_PERCENT_FEE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TipOrConvenience {
  public static final String JSON_PROPERTY_TYPE = "type";
  private TipOrConvenienceEnum type;

  public static final String JSON_PROPERTY_FLAT_FEE = "flatFee";
  private JsonNullable<Double> flatFee = JsonNullable.<Double>undefined();

  public static final String JSON_PROPERTY_PERCENT_FEE = "percentFee";
  private JsonNullable<Double> percentFee = JsonNullable.<Double>undefined();

  public TipOrConvenience() {
  }

  public TipOrConvenience type(TipOrConvenienceEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TipOrConvenienceEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TipOrConvenienceEnum type) {
    this.type = type;
  }


  public TipOrConvenience flatFee(Double flatFee) {
    this.flatFee = JsonNullable.<Double>of(flatFee);
    
    return this;
  }

   /**
   * Комиссия задана в фиксированной сумме.
   * @return flatFee
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public Double getFlatFee() {
        return flatFee.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FLAT_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getFlatFee_JsonNullable() {
    return flatFee;
  }
  
  @JsonProperty(JSON_PROPERTY_FLAT_FEE)
  public void setFlatFee_JsonNullable(JsonNullable<Double> flatFee) {
    this.flatFee = flatFee;
  }

  public void setFlatFee(Double flatFee) {
    this.flatFee = JsonNullable.<Double>of(flatFee);
  }


  public TipOrConvenience percentFee(Double percentFee) {
    this.percentFee = JsonNullable.<Double>of(percentFee);
    
    return this;
  }

   /**
   * Комиссия задана в процентах от суммы оплаты.
   * @return percentFee
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public Double getPercentFee() {
        return percentFee.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PERCENT_FEE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Double> getPercentFee_JsonNullable() {
    return percentFee;
  }
  
  @JsonProperty(JSON_PROPERTY_PERCENT_FEE)
  public void setPercentFee_JsonNullable(JsonNullable<Double> percentFee) {
    this.percentFee = percentFee;
  }

  public void setPercentFee(Double percentFee) {
    this.percentFee = JsonNullable.<Double>of(percentFee);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipOrConvenience tipOrConvenience = (TipOrConvenience) o;
    return Objects.equals(this.type, tipOrConvenience.type) &&
        equalsNullable(this.flatFee, tipOrConvenience.flatFee) &&
        equalsNullable(this.percentFee, tipOrConvenience.percentFee);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, hashCodeNullable(flatFee), hashCodeNullable(percentFee));
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
    sb.append("class TipOrConvenience {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    flatFee: ").append(toIndentedString(flatFee)).append("\n");
    sb.append("    percentFee: ").append(toIndentedString(percentFee)).append("\n");
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

