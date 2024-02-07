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
 * Данные для регистрации устройства на кассе
 */
@JsonPropertyOrder({
  CashBoxRegistrationInfo.JSON_PROPERTY_SERVICE_ID,
  CashBoxRegistrationInfo.JSON_PROPERTY_RTT_CODE,
  CashBoxRegistrationInfo.JSON_PROPERTY_CASH_BOX_CODE,
  CashBoxRegistrationInfo.JSON_PROPERTY_PLAYER_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CashBoxRegistrationInfo {
  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";
  private Integer serviceId;

  public static final String JSON_PROPERTY_RTT_CODE = "rttCode";
  private Integer rttCode;

  public static final String JSON_PROPERTY_CASH_BOX_CODE = "cashBoxCode";
  private Integer cashBoxCode;

  public static final String JSON_PROPERTY_PLAYER_ID = "playerId";
  private JsonNullable<String> playerId = JsonNullable.<String>undefined();

  public CashBoxRegistrationInfo() {
  }

  public CashBoxRegistrationInfo serviceId(Integer serviceId) {
    
    this.serviceId = serviceId;
    return this;
  }

   /**
   * Идентификатор услуги
   * @return serviceId
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_SERVICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getServiceId() {
    return serviceId;
  }


  @JsonProperty(JSON_PROPERTY_SERVICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setServiceId(Integer serviceId) {
    this.serviceId = serviceId;
  }


  public CashBoxRegistrationInfo rttCode(Integer rttCode) {
    
    this.rttCode = rttCode;
    return this;
  }

   /**
   * Идентификатор РТТ
   * @return rttCode
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_RTT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRttCode() {
    return rttCode;
  }


  @JsonProperty(JSON_PROPERTY_RTT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRttCode(Integer rttCode) {
    this.rttCode = rttCode;
  }


  public CashBoxRegistrationInfo cashBoxCode(Integer cashBoxCode) {
    
    this.cashBoxCode = cashBoxCode;
    return this;
  }

   /**
   * Идентификатор кассы
   * @return cashBoxCode
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_CASH_BOX_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCashBoxCode() {
    return cashBoxCode;
  }


  @JsonProperty(JSON_PROPERTY_CASH_BOX_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCashBoxCode(Integer cashBoxCode) {
    this.cashBoxCode = cashBoxCode;
  }


  public CashBoxRegistrationInfo playerId(String playerId) {
    this.playerId = JsonNullable.<String>of(playerId);
    
    return this;
  }

   /**
   * Идентификатор устройства в OneSignal
   * @return playerId
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getPlayerId() {
        return playerId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PLAYER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getPlayerId_JsonNullable() {
    return playerId;
  }
  
  @JsonProperty(JSON_PROPERTY_PLAYER_ID)
  public void setPlayerId_JsonNullable(JsonNullable<String> playerId) {
    this.playerId = playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = JsonNullable.<String>of(playerId);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CashBoxRegistrationInfo cashBoxRegistrationInfo = (CashBoxRegistrationInfo) o;
    return Objects.equals(this.serviceId, cashBoxRegistrationInfo.serviceId) &&
        Objects.equals(this.rttCode, cashBoxRegistrationInfo.rttCode) &&
        Objects.equals(this.cashBoxCode, cashBoxRegistrationInfo.cashBoxCode) &&
        equalsNullable(this.playerId, cashBoxRegistrationInfo.playerId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, rttCode, cashBoxCode, hashCodeNullable(playerId));
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
    sb.append("class CashBoxRegistrationInfo {\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    rttCode: ").append(toIndentedString(rttCode)).append("\n");
    sb.append("    cashBoxCode: ").append(toIndentedString(cashBoxCode)).append("\n");
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
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

