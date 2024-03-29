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
import by.sportliner.lk.integration.epos.hgrosh.internal.api.InvoiceListItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Список элементов при постраничной выдаче.
 */
@JsonPropertyOrder({
  InvoiceListItemRecords.JSON_PROPERTY_START,
  InvoiceListItemRecords.JSON_PROPERTY_COUNT,
  InvoiceListItemRecords.JSON_PROPERTY_TOTAL,
  InvoiceListItemRecords.JSON_PROPERTY_RECORDS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class InvoiceListItemRecords {
  public static final String JSON_PROPERTY_START = "start";
  private Integer start;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;

  public static final String JSON_PROPERTY_TOTAL = "total";
  private Integer total;

  public static final String JSON_PROPERTY_RECORDS = "records";
  private JsonNullable<List<InvoiceListItem>> records = JsonNullable.<List<InvoiceListItem>>undefined();

  public InvoiceListItemRecords() {
  }

  public InvoiceListItemRecords start(Integer start) {
    
    this.start = start;
    return this;
  }

   /**
   * Индекс начального элемента.
   * @return start
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_START)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getStart() {
    return start;
  }


  @JsonProperty(JSON_PROPERTY_START)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStart(Integer start) {
    this.start = start;
  }


  public InvoiceListItemRecords count(Integer count) {
    
    this.count = count;
    return this;
  }

   /**
   * Количество элементов в результате.
   * @return count
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCount() {
    return count;
  }


  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCount(Integer count) {
    this.count = count;
  }


  public InvoiceListItemRecords total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * Общее количество элементов, удовлетворяющих запросу.
   * @return total
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTotal() {
    return total;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotal(Integer total) {
    this.total = total;
  }


  public InvoiceListItemRecords records(List<InvoiceListItem> records) {
    this.records = JsonNullable.<List<InvoiceListItem>>of(records);
    
    return this;
  }

  public InvoiceListItemRecords addRecordsItem(InvoiceListItem recordsItem) {
    if (this.records == null || !this.records.isPresent()) {
      this.records = JsonNullable.<List<InvoiceListItem>>of(new ArrayList<>());
    }
    try {
      this.records.get().add(recordsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Запрошенные записи.
   * @return records
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonIgnore

  public List<InvoiceListItem> getRecords() {
        return records.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<InvoiceListItem>> getRecords_JsonNullable() {
    return records;
  }
  
  @JsonProperty(JSON_PROPERTY_RECORDS)
  public void setRecords_JsonNullable(JsonNullable<List<InvoiceListItem>> records) {
    this.records = records;
  }

  public void setRecords(List<InvoiceListItem> records) {
    this.records = JsonNullable.<List<InvoiceListItem>>of(records);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoiceListItemRecords invoiceListItemRecords = (InvoiceListItemRecords) o;
    return Objects.equals(this.start, invoiceListItemRecords.start) &&
        Objects.equals(this.count, invoiceListItemRecords.count) &&
        Objects.equals(this.total, invoiceListItemRecords.total) &&
        equalsNullable(this.records, invoiceListItemRecords.records);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, count, total, hashCodeNullable(records));
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
    sb.append("class InvoiceListItemRecords {\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    records: ").append(toIndentedString(records)).append("\n");
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

