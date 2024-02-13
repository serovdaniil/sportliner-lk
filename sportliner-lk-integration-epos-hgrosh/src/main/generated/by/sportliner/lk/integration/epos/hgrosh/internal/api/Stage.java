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
 * Этап оплаты счета в рассрочку.
 */
@JsonPropertyOrder({
  Stage.JSON_PROPERTY_LAST_PAYMENT_U_T_C,
  Stage.JSON_PROPERTY_PAY_DATE_U_T_C,
  Stage.JSON_PROPERTY_MIN_PAYMENT,
  Stage.JSON_PROPERTY_AMOUNT_PAID,
  Stage.JSON_PROPERTY_PENALTY,
  Stage.JSON_PROPERTY_IS_COMPLETED
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Stage {
  public static final String JSON_PROPERTY_LAST_PAYMENT_U_T_C = "lastPaymentUTC";
  private java.time.LocalDateTime lastPaymentUTC;

  public static final String JSON_PROPERTY_PAY_DATE_U_T_C = "payDateUTC";
  private java.time.LocalDateTime payDateUTC;

  public static final String JSON_PROPERTY_MIN_PAYMENT = "minPayment";
  private Double minPayment;

  public static final String JSON_PROPERTY_AMOUNT_PAID = "amountPaid";
  private Double amountPaid;

  public static final String JSON_PROPERTY_PENALTY = "penalty";
  private Double penalty;

  public static final String JSON_PROPERTY_IS_COMPLETED = "isCompleted";
  private Boolean isCompleted;

  public Stage() {
  }

  @JsonCreator
  public Stage(
    @JsonProperty(JSON_PROPERTY_IS_COMPLETED) Boolean isCompleted
  ) {
    this();
    this.isCompleted = isCompleted;
  }

  public Stage lastPaymentUTC(java.time.LocalDateTime lastPaymentUTC) {
    
    this.lastPaymentUTC = lastPaymentUTC;
    return this;
  }

   /**
   * Get lastPaymentUTC
   * @return lastPaymentUTC
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_LAST_PAYMENT_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.time.LocalDateTime getLastPaymentUTC() {
    return lastPaymentUTC;
  }


  @JsonProperty(JSON_PROPERTY_LAST_PAYMENT_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastPaymentUTC(java.time.LocalDateTime lastPaymentUTC) {
    this.lastPaymentUTC = lastPaymentUTC;
  }


  public Stage payDateUTC(java.time.LocalDateTime payDateUTC) {
    
    this.payDateUTC = payDateUTC;
    return this;
  }

   /**
   * Get payDateUTC
   * @return payDateUTC
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_PAY_DATE_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.time.LocalDateTime getPayDateUTC() {
    return payDateUTC;
  }


  @JsonProperty(JSON_PROPERTY_PAY_DATE_U_T_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayDateUTC(java.time.LocalDateTime payDateUTC) {
    this.payDateUTC = payDateUTC;
  }


  public Stage minPayment(Double minPayment) {
    
    this.minPayment = minPayment;
    return this;
  }

   /**
   * Минимальная сумма оплаты.
   * @return minPayment
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_MIN_PAYMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMinPayment() {
    return minPayment;
  }


  @JsonProperty(JSON_PROPERTY_MIN_PAYMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMinPayment(Double minPayment) {
    this.minPayment = minPayment;
  }


  public Stage amountPaid(Double amountPaid) {
    
    this.amountPaid = amountPaid;
    return this;
  }

   /**
   * Оплачено по данному этапу
   * @return amountPaid
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_AMOUNT_PAID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getAmountPaid() {
    return amountPaid;
  }


  @JsonProperty(JSON_PROPERTY_AMOUNT_PAID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAmountPaid(Double amountPaid) {
    this.amountPaid = amountPaid;
  }


  public Stage penalty(Double penalty) {
    
    this.penalty = penalty;
    return this;
  }

   /**
   * Пеня по платежу
   * @return penalty
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PENALTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getPenalty() {
    return penalty;
  }


  @JsonProperty(JSON_PROPERTY_PENALTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPenalty(Double penalty) {
    this.penalty = penalty;
  }


   /**
   * Этап оплачен
   * @return isCompleted
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_IS_COMPLETED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isIsCompleted() {
    return isCompleted;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stage stage = (Stage) o;
    return Objects.equals(this.lastPaymentUTC, stage.lastPaymentUTC) &&
        Objects.equals(this.payDateUTC, stage.payDateUTC) &&
        Objects.equals(this.minPayment, stage.minPayment) &&
        Objects.equals(this.amountPaid, stage.amountPaid) &&
        Objects.equals(this.penalty, stage.penalty) &&
        Objects.equals(this.isCompleted, stage.isCompleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastPaymentUTC, payDateUTC, minPayment, amountPaid, penalty, isCompleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stage {\n");
    sb.append("    lastPaymentUTC: ").append(toIndentedString(lastPaymentUTC)).append("\n");
    sb.append("    payDateUTC: ").append(toIndentedString(payDateUTC)).append("\n");
    sb.append("    minPayment: ").append(toIndentedString(minPayment)).append("\n");
    sb.append("    amountPaid: ").append(toIndentedString(amountPaid)).append("\n");
    sb.append("    penalty: ").append(toIndentedString(penalty)).append("\n");
    sb.append("    isCompleted: ").append(toIndentedString(isCompleted)).append("\n");
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

