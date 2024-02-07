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
import by.sportliner.lk.integration.epos.hgrosh.internal.api.GEOLocation;
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
 * Почтовый адрес.
 */
@JsonPropertyOrder({
  Address.JSON_PROPERTY_COUNTRY,
  Address.JSON_PROPERTY_LINE1,
  Address.JSON_PROPERTY_LINE2,
  Address.JSON_PROPERTY_CITY,
  Address.JSON_PROPERTY_POSTAL_CODE,
  Address.JSON_PROPERTY_LOCATION,
  Address.JSON_PROPERTY_FULL_ADDRESS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Address {
  public static final String JSON_PROPERTY_COUNTRY = "country";
  private JsonNullable<String> country = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_LINE1 = "line1";
  private JsonNullable<String> line1 = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_LINE2 = "line2";
  private JsonNullable<String> line2 = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_CITY = "city";
  private JsonNullable<String> city = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_POSTAL_CODE = "postalCode";
  private JsonNullable<String> postalCode = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_LOCATION = "location";
  private GEOLocation location;

  public static final String JSON_PROPERTY_FULL_ADDRESS = "fullAddress";
  private JsonNullable<String> fullAddress = JsonNullable.<String>undefined();

  public Address() {
  }

  @JsonCreator
  public Address(
    @JsonProperty(JSON_PROPERTY_FULL_ADDRESS) String fullAddress
  ) {
    this();
    this.fullAddress = fullAddress == null ? JsonNullable.<String>undefined() : JsonNullable.of(fullAddress);
  }

  public Address country(String country) {
    this.country = JsonNullable.<String>of(country);
    
    return this;
  }

   /**
   * 2-х&#x3D;символьный код страны
   * @return country
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getCountry() {
        return country.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getCountry_JsonNullable() {
    return country;
  }
  
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  public void setCountry_JsonNullable(JsonNullable<String> country) {
    this.country = country;
  }

  public void setCountry(String country) {
    this.country = JsonNullable.<String>of(country);
  }


  public Address line1(String line1) {
    this.line1 = JsonNullable.<String>of(line1);
    
    return this;
  }

   /**
   * Первая строка адреса (например, дом, улице и т.п.).
   * @return line1
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getLine1() {
        return line1.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getLine1_JsonNullable() {
    return line1;
  }
  
  @JsonProperty(JSON_PROPERTY_LINE1)
  public void setLine1_JsonNullable(JsonNullable<String> line1) {
    this.line1 = line1;
  }

  public void setLine1(String line1) {
    this.line1 = JsonNullable.<String>of(line1);
  }


  public Address line2(String line2) {
    this.line2 = JsonNullable.<String>of(line2);
    
    return this;
  }

   /**
   * Вторая строка адреса (например, номер апартаментов, квартиры и т.п.).
   * @return line2
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getLine2() {
        return line2.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LINE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getLine2_JsonNullable() {
    return line2;
  }
  
  @JsonProperty(JSON_PROPERTY_LINE2)
  public void setLine2_JsonNullable(JsonNullable<String> line2) {
    this.line2 = line2;
  }

  public void setLine2(String line2) {
    this.line2 = JsonNullable.<String>of(line2);
  }


  public Address city(String city) {
    this.city = JsonNullable.<String>of(city);
    
    return this;
  }

   /**
   * Город.
   * @return city
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getCity() {
        return city.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getCity_JsonNullable() {
    return city;
  }
  
  @JsonProperty(JSON_PROPERTY_CITY)
  public void setCity_JsonNullable(JsonNullable<String> city) {
    this.city = city;
  }

  public void setCity(String city) {
    this.city = JsonNullable.<String>of(city);
  }


  public Address postalCode(String postalCode) {
    this.postalCode = JsonNullable.<String>of(postalCode);
    
    return this;
  }

   /**
   * Почтовый индекс.
   * @return postalCode
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getPostalCode() {
        return postalCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPostalCode_JsonNullable() {
    return postalCode;
  }
  
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  public void setPostalCode_JsonNullable(JsonNullable<String> postalCode) {
    this.postalCode = postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = JsonNullable.<String>of(postalCode);
  }


  public Address location(GEOLocation location) {
    
    this.location = location;
    return this;
  }

   /**
   * Get location
   * @return location
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public GEOLocation getLocation() {
    return location;
  }


  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocation(GEOLocation location) {
    this.location = location;
  }


   /**
   * Полный адрес
   * @return fullAddress
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getFullAddress() {
    
    if (fullAddress == null) {
      fullAddress = JsonNullable.<String>undefined();
    }
    return fullAddress.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FULL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getFullAddress_JsonNullable() {
    return fullAddress;
  }
  
  @JsonProperty(JSON_PROPERTY_FULL_ADDRESS)
  private void setFullAddress_JsonNullable(JsonNullable<String> fullAddress) {
    this.fullAddress = fullAddress;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return equalsNullable(this.country, address.country) &&
        equalsNullable(this.line1, address.line1) &&
        equalsNullable(this.line2, address.line2) &&
        equalsNullable(this.city, address.city) &&
        equalsNullable(this.postalCode, address.postalCode) &&
        Objects.equals(this.location, address.location) &&
        equalsNullable(this.fullAddress, address.fullAddress);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(country), hashCodeNullable(line1), hashCodeNullable(line2), hashCodeNullable(city), hashCodeNullable(postalCode), location, hashCodeNullable(fullAddress));
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
    sb.append("class Address {\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    fullAddress: ").append(toIndentedString(fullAddress)).append("\n");
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
