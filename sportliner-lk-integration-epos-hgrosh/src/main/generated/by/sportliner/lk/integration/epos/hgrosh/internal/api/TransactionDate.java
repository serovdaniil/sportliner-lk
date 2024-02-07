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
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Структура дат транзакции
 */
@JsonPropertyOrder({
  TransactionDate.JSON_PROPERTY_DATE_START_U_T_C,
  TransactionDate.JSON_PROPERTY_DATE_RESULT_U_T_C,
  TransactionDate.JSON_PROPERTY_DATE_VERIFIED_U_T_C
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionDate {
  public static final String JSON_PROPERTY_DATE_START_U_T_C = "dateStartUTC";
  private LocalDateTime dateStartUTC;

  public static final String JSON_PROPERTY_DATE_RESULT_U_T_C = "dateResultUTC";
  private LocalDateTime dateResultUTC;

  public static final String JSON_PROPERTY_DATE_VERIFIED_U_T_C = "dateVerifiedUTC";
  private LocalDateTime dateVerifiedUTC;

  public TransactionDate() {
  }

  public TransactionDate dateStartUTC(LocalDateTime dateStartUTC) {
    
    this.dateStartUTC = dateStartUTC;
    return this;
  }

   /**
   * Get dateStartUTC
   * @return dateStartUTC
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_DATE_START_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocalDateTime getDateStartUTC() {
    return dateStartUTC;
  }


  @JsonProperty(JSON_PROPERTY_DATE_START_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDateStartUTC(LocalDateTime dateStartUTC) {
    this.dateStartUTC = dateStartUTC;
  }


  public TransactionDate dateResultUTC(LocalDateTime dateResultUTC) {
    
    this.dateResultUTC = dateResultUTC;
    return this;
  }

   /**
   * Get dateResultUTC
   * @return dateResultUTC
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_DATE_RESULT_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocalDateTime getDateResultUTC() {
    return dateResultUTC;
  }


  @JsonProperty(JSON_PROPERTY_DATE_RESULT_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDateResultUTC(LocalDateTime dateResultUTC) {
    this.dateResultUTC = dateResultUTC;
  }


  public TransactionDate dateVerifiedUTC(LocalDateTime dateVerifiedUTC) {
    
    this.dateVerifiedUTC = dateVerifiedUTC;
    return this;
  }

   /**
   * Get dateVerifiedUTC
   * @return dateVerifiedUTC
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_DATE_VERIFIED_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocalDateTime getDateVerifiedUTC() {
    return dateVerifiedUTC;
  }


  @JsonProperty(JSON_PROPERTY_DATE_VERIFIED_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDateVerifiedUTC(LocalDateTime dateVerifiedUTC) {
    this.dateVerifiedUTC = dateVerifiedUTC;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionDate transactionDate = (TransactionDate) o;
    return Objects.equals(this.dateStartUTC, transactionDate.dateStartUTC) &&
        Objects.equals(this.dateResultUTC, transactionDate.dateResultUTC) &&
        Objects.equals(this.dateVerifiedUTC, transactionDate.dateVerifiedUTC);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateStartUTC, dateResultUTC, dateVerifiedUTC);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionDate {\n");
    sb.append("    dateStartUTC: ").append(toIndentedString(dateStartUTC)).append("\n");
    sb.append("    dateResultUTC: ").append(toIndentedString(dateResultUTC)).append("\n");
    sb.append("    dateVerifiedUTC: ").append(toIndentedString(dateVerifiedUTC)).append("\n");
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
