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
 * Валюта.
 */
@JsonPropertyOrder({
  Currency.JSON_PROPERTY_CODE,
  Currency.JSON_PROPERTY_ABBR,
  Currency.JSON_PROPERTY_EXPONENT,
  Currency.JSON_PROPERTY_IS_NATIONAL,
  Currency.JSON_PROPERTY_IS_MAIN,
  Currency.JSON_PROPERTY_NAME,
  Currency.JSON_PROPERTY_IS_ACTIVE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Currency {
  public static final String JSON_PROPERTY_CODE = "code";
  private Integer code;

  public static final String JSON_PROPERTY_ABBR = "abbr";
  private JsonNullable<String> abbr = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_EXPONENT = "exponent";
  private JsonNullable<Integer> exponent = JsonNullable.<Integer>undefined();

  public static final String JSON_PROPERTY_IS_NATIONAL = "isNational";
  private Boolean isNational;

  public static final String JSON_PROPERTY_IS_MAIN = "isMain";
  private Boolean isMain;

  public static final String JSON_PROPERTY_NAME = "name";
  private JsonNullable<String> name = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_IS_ACTIVE = "isActive";
  private Boolean isActive;

  public Currency() {
  }

  public Currency code(Integer code) {
    
    this.code = code;
    return this;
  }

   /**
   * Международный код валюты (ISO 4217) (уникальный код).
   * @return code
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCode() {
    return code;
  }


  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCode(Integer code) {
    this.code = code;
  }


  public Currency abbr(String abbr) {
    this.abbr = JsonNullable.<String>of(abbr);
    
    return this;
  }

   /**
   * Международная аббревиатура валюты (ISO 4217).
   * @return abbr
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getAbbr() {
        return abbr.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ABBR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getAbbr_JsonNullable() {
    return abbr;
  }
  
  @JsonProperty(JSON_PROPERTY_ABBR)
  public void setAbbr_JsonNullable(JsonNullable<String> abbr) {
    this.abbr = abbr;
  }

  public void setAbbr(String abbr) {
    this.abbr = JsonNullable.<String>of(abbr);
  }


  public Currency exponent(Integer exponent) {
    this.exponent = JsonNullable.<Integer>of(exponent);
    
    return this;
  }

   /**
   * Признак наличия разменных денежных единиц     0 — отсутствие разменной денежной единицы (такая единица могла существовать в прошлом, но в результате инфляции она обесценилась настолько, что в обращении не участвует и/или для учёта не используется)     2 — наличие разменной денежной единицы, которая равна 1⁄100 базовой валюты     3 — наличие разменной денежной единицы, которая равна 1⁄1000 базовой валюты     null — отсутствие разменной денежной единицы (используется для описания валютных ценностей и фондов)
   * @return exponent
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public Integer getExponent() {
        return exponent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPONENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Integer> getExponent_JsonNullable() {
    return exponent;
  }
  
  @JsonProperty(JSON_PROPERTY_EXPONENT)
  public void setExponent_JsonNullable(JsonNullable<Integer> exponent) {
    this.exponent = exponent;
  }

  public void setExponent(Integer exponent) {
    this.exponent = JsonNullable.<Integer>of(exponent);
  }


  public Currency isNational(Boolean isNational) {
    
    this.isNational = isNational;
    return this;
  }

   /**
   * Признак национальной валюты.
   * @return isNational
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_IS_NATIONAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isIsNational() {
    return isNational;
  }


  @JsonProperty(JSON_PROPERTY_IS_NATIONAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIsNational(Boolean isNational) {
    this.isNational = isNational;
  }


  public Currency isMain(Boolean isMain) {
    
    this.isMain = isMain;
    return this;
  }

   /**
   * Признак \&quot;основной\&quot; валюты.
   * @return isMain
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_IS_MAIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isIsMain() {
    return isMain;
  }


  @JsonProperty(JSON_PROPERTY_IS_MAIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIsMain(Boolean isMain) {
    this.isMain = isMain;
  }


  public Currency name(String name) {
    this.name = JsonNullable.<String>of(name);
    
    return this;
  }

   /**
   * Наименование валюты.
   * @return name
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getName() {
        return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getName_JsonNullable() {
    return name;
  }
  
  @JsonProperty(JSON_PROPERTY_NAME)
  public void setName_JsonNullable(JsonNullable<String> name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = JsonNullable.<String>of(name);
  }


  public Currency isActive(Boolean isActive) {
    
    this.isActive = isActive;
    return this;
  }

   /**
   * Признак активности валюты.
   * @return isActive
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_IS_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isIsActive() {
    return isActive;
  }


  @JsonProperty(JSON_PROPERTY_IS_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Currency currency = (Currency) o;
    return Objects.equals(this.code, currency.code) &&
        equalsNullable(this.abbr, currency.abbr) &&
        equalsNullable(this.exponent, currency.exponent) &&
        Objects.equals(this.isNational, currency.isNational) &&
        Objects.equals(this.isMain, currency.isMain) &&
        equalsNullable(this.name, currency.name) &&
        Objects.equals(this.isActive, currency.isActive);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, hashCodeNullable(abbr), hashCodeNullable(exponent), isNational, isMain, hashCodeNullable(name), isActive);
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
    sb.append("class Currency {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    abbr: ").append(toIndentedString(abbr)).append("\n");
    sb.append("    exponent: ").append(toIndentedString(exponent)).append("\n");
    sb.append("    isNational: ").append(toIndentedString(isNational)).append("\n");
    sb.append("    isMain: ").append(toIndentedString(isMain)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
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

