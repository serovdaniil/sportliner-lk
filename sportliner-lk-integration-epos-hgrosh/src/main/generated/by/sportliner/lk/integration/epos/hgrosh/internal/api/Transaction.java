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
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionAmount;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionBankData;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionClient;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionDate;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionInvoice;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionServiceData;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.TransactionStateEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Прошедшая транзакция оплаты
 */
@JsonPropertyOrder({
  Transaction.JSON_PROPERTY_ID,
  Transaction.JSON_PROPERTY_SERVICE_DATA,
  Transaction.JSON_PROPERTY_AMOUNT,
  Transaction.JSON_PROPERTY_ERIP_ID,
  Transaction.JSON_PROPERTY_EPOS_ID,
  Transaction.JSON_PROPERTY_AGGREGATOR_ID,
  Transaction.JSON_PROPERTY_SP_TRAN_ID,
  Transaction.JSON_PROPERTY_DATES,
  Transaction.JSON_PROPERTY_CLIENT,
  Transaction.JSON_PROPERTY_STATE,
  Transaction.JSON_PROPERTY_BANK_DATA,
  Transaction.JSON_PROPERTY_INVOICE,
  Transaction.JSON_PROPERTY_EPOS_INFO
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Transaction {
  public static final String JSON_PROPERTY_ID = "id";
  private UUID id;

  public static final String JSON_PROPERTY_SERVICE_DATA = "serviceData";
  private TransactionServiceData serviceData;

  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private TransactionAmount amount;

  public static final String JSON_PROPERTY_ERIP_ID = "eripId";
  private Long eripId;

  public static final String JSON_PROPERTY_EPOS_ID = "eposId";
  private Long eposId;

  public static final String JSON_PROPERTY_AGGREGATOR_ID = "aggregatorId";
  private Long aggregatorId;

  public static final String JSON_PROPERTY_SP_TRAN_ID = "spTranId";
  private Long spTranId;

  public static final String JSON_PROPERTY_DATES = "dates";
  private TransactionDate dates;

  public static final String JSON_PROPERTY_CLIENT = "client";
  private TransactionClient client;

  public static final String JSON_PROPERTY_STATE = "state";
  private TransactionStateEnum state;

  public static final String JSON_PROPERTY_BANK_DATA = "bankData";
  private TransactionBankData bankData;

  public static final String JSON_PROPERTY_INVOICE = "invoice";
  private TransactionInvoice invoice;

  public static final String JSON_PROPERTY_EPOS_INFO = "eposInfo";
  private JsonNullable<String> eposInfo = JsonNullable.<String>undefined();

  public Transaction() {
  }

  public Transaction id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * Уникальный идентификатор транзакции
   * @return id
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UUID getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(UUID id) {
    this.id = id;
  }


  public Transaction serviceData(TransactionServiceData serviceData) {
    
    this.serviceData = serviceData;
    return this;
  }

   /**
   * Get serviceData
   * @return serviceData
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_SERVICE_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionServiceData getServiceData() {
    return serviceData;
  }


  @JsonProperty(JSON_PROPERTY_SERVICE_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setServiceData(TransactionServiceData serviceData) {
    this.serviceData = serviceData;
  }


  public Transaction amount(TransactionAmount amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionAmount getAmount() {
    return amount;
  }


  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAmount(TransactionAmount amount) {
    this.amount = amount;
  }


  public Transaction eripId(Long eripId) {
    
    this.eripId = eripId;
    return this;
  }

   /**
   * Идентификатор транзакции в ЕРИП
   * @return eripId
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_ERIP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getEripId() {
    return eripId;
  }


  @JsonProperty(JSON_PROPERTY_ERIP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEripId(Long eripId) {
    this.eripId = eripId;
  }


  public Transaction eposId(Long eposId) {
    
    this.eposId = eposId;
    return this;
  }

   /**
   * Внутренний идентификатор транзакции EPos
   * @return eposId
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_EPOS_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getEposId() {
    return eposId;
  }


  @JsonProperty(JSON_PROPERTY_EPOS_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEposId(Long eposId) {
    this.eposId = eposId;
  }


  public Transaction aggregatorId(Long aggregatorId) {
    
    this.aggregatorId = aggregatorId;
    return this;
  }

   /**
   * Идентификатор транзакции у агрегатора
   * @return aggregatorId
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_AGGREGATOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getAggregatorId() {
    return aggregatorId;
  }


  @JsonProperty(JSON_PROPERTY_AGGREGATOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAggregatorId(Long aggregatorId) {
    this.aggregatorId = aggregatorId;
  }


  public Transaction spTranId(Long spTranId) {
    
    this.spTranId = spTranId;
    return this;
  }

   /**
   * Идентификатор транзакции самого ПУ
   * @return spTranId
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_SP_TRAN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getSpTranId() {
    return spTranId;
  }


  @JsonProperty(JSON_PROPERTY_SP_TRAN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpTranId(Long spTranId) {
    this.spTranId = spTranId;
  }


  public Transaction dates(TransactionDate dates) {
    
    this.dates = dates;
    return this;
  }

   /**
   * Get dates
   * @return dates
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_DATES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionDate getDates() {
    return dates;
  }


  @JsonProperty(JSON_PROPERTY_DATES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDates(TransactionDate dates) {
    this.dates = dates;
  }


  public Transaction client(TransactionClient client) {
    
    this.client = client;
    return this;
  }

   /**
   * Get client
   * @return client
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_CLIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionClient getClient() {
    return client;
  }


  @JsonProperty(JSON_PROPERTY_CLIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClient(TransactionClient client) {
    this.client = client;
  }


  public Transaction state(TransactionStateEnum state) {
    
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionStateEnum getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(TransactionStateEnum state) {
    this.state = state;
  }


  public Transaction bankData(TransactionBankData bankData) {
    
    this.bankData = bankData;
    return this;
  }

   /**
   * Get bankData
   * @return bankData
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_BANK_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionBankData getBankData() {
    return bankData;
  }


  @JsonProperty(JSON_PROPERTY_BANK_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBankData(TransactionBankData bankData) {
    this.bankData = bankData;
  }


  public Transaction invoice(TransactionInvoice invoice) {
    
    this.invoice = invoice;
    return this;
  }

   /**
   * Get invoice
   * @return invoice
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_INVOICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionInvoice getInvoice() {
    return invoice;
  }


  @JsonProperty(JSON_PROPERTY_INVOICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvoice(TransactionInvoice invoice) {
    this.invoice = invoice;
  }


  public Transaction eposInfo(String eposInfo) {
    this.eposInfo = JsonNullable.<String>of(eposInfo);
    
    return this;
  }

   /**
   * Информация по транзакции и суммам
   * @return eposInfo
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getEposInfo() {
        return eposInfo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EPOS_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getEposInfo_JsonNullable() {
    return eposInfo;
  }
  
  @JsonProperty(JSON_PROPERTY_EPOS_INFO)
  public void setEposInfo_JsonNullable(JsonNullable<String> eposInfo) {
    this.eposInfo = eposInfo;
  }

  public void setEposInfo(String eposInfo) {
    this.eposInfo = JsonNullable.<String>of(eposInfo);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.serviceData, transaction.serviceData) &&
        Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.eripId, transaction.eripId) &&
        Objects.equals(this.eposId, transaction.eposId) &&
        Objects.equals(this.aggregatorId, transaction.aggregatorId) &&
        Objects.equals(this.spTranId, transaction.spTranId) &&
        Objects.equals(this.dates, transaction.dates) &&
        Objects.equals(this.client, transaction.client) &&
        Objects.equals(this.state, transaction.state) &&
        Objects.equals(this.bankData, transaction.bankData) &&
        Objects.equals(this.invoice, transaction.invoice) &&
        equalsNullable(this.eposInfo, transaction.eposInfo);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, serviceData, amount, eripId, eposId, aggregatorId, spTranId, dates, client, state, bankData, invoice, hashCodeNullable(eposInfo));
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
    sb.append("class Transaction {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    serviceData: ").append(toIndentedString(serviceData)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    eripId: ").append(toIndentedString(eripId)).append("\n");
    sb.append("    eposId: ").append(toIndentedString(eposId)).append("\n");
    sb.append("    aggregatorId: ").append(toIndentedString(aggregatorId)).append("\n");
    sb.append("    spTranId: ").append(toIndentedString(spTranId)).append("\n");
    sb.append("    dates: ").append(toIndentedString(dates)).append("\n");
    sb.append("    client: ").append(toIndentedString(client)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    bankData: ").append(toIndentedString(bankData)).append("\n");
    sb.append("    invoice: ").append(toIndentedString(invoice)).append("\n");
    sb.append("    eposInfo: ").append(toIndentedString(eposInfo)).append("\n");
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
