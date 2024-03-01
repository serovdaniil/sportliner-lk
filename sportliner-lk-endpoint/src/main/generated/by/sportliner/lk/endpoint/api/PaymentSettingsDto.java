package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.PriceItemDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Payment settings
 */

@Schema(name = "PaymentSettings", description = "Payment settings")
@JsonTypeName("PaymentSettings")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PaymentSettingsDto {

  @JsonProperty("usePrevPrice")
  private Boolean usePrevPrice;

  @JsonProperty("currentPrice")
  @Valid
  private List<PriceItemDto> currentPrice = new ArrayList<>();

  @JsonProperty("prevPrice")
  @Valid
  private List<PriceItemDto> prevPrice = new ArrayList<>();

  public PaymentSettingsDto usePrevPrice(Boolean usePrevPrice) {
    this.usePrevPrice = usePrevPrice;
    return this;
  }

  /**
   * Need to use prev price
   * @return usePrevPrice
  */
  @NotNull 
  @Schema(name = "usePrevPrice", description = "Need to use prev price", requiredMode = Schema.RequiredMode.REQUIRED)
  public Boolean isUsePrevPrice() {
    return usePrevPrice;
  }

  public void setUsePrevPrice(Boolean usePrevPrice) {
    this.usePrevPrice = usePrevPrice;
  }

  public PaymentSettingsDto currentPrice(List<PriceItemDto> currentPrice) {
    this.currentPrice = currentPrice;
    return this;
  }

  public PaymentSettingsDto addCurrentPriceItem(PriceItemDto currentPriceItem) {
    this.currentPrice.add(currentPriceItem);
    return this;
  }

  /**
   * Current price
   * @return currentPrice
  */
  @NotNull @Valid 
  @Schema(name = "currentPrice", description = "Current price", requiredMode = Schema.RequiredMode.REQUIRED)
  public List<PriceItemDto> getCurrentPrice() {
    return currentPrice;
  }

  public void setCurrentPrice(List<PriceItemDto> currentPrice) {
    this.currentPrice = currentPrice;
  }

  public PaymentSettingsDto prevPrice(List<PriceItemDto> prevPrice) {
    this.prevPrice = prevPrice;
    return this;
  }

  public PaymentSettingsDto addPrevPriceItem(PriceItemDto prevPriceItem) {
    this.prevPrice.add(prevPriceItem);
    return this;
  }

  /**
   * Prev price
   * @return prevPrice
  */
  @NotNull @Valid 
  @Schema(name = "prevPrice", description = "Prev price", requiredMode = Schema.RequiredMode.REQUIRED)
  public List<PriceItemDto> getPrevPrice() {
    return prevPrice;
  }

  public void setPrevPrice(List<PriceItemDto> prevPrice) {
    this.prevPrice = prevPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentSettingsDto paymentSettings = (PaymentSettingsDto) o;
    return Objects.equals(this.usePrevPrice, paymentSettings.usePrevPrice) &&
        Objects.equals(this.currentPrice, paymentSettings.currentPrice) &&
        Objects.equals(this.prevPrice, paymentSettings.prevPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usePrevPrice, currentPrice, prevPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentSettingsDto {\n");
    sb.append("    usePrevPrice: ").append(toIndentedString(usePrevPrice)).append("\n");
    sb.append("    currentPrice: ").append(toIndentedString(currentPrice)).append("\n");
    sb.append("    prevPrice: ").append(toIndentedString(prevPrice)).append("\n");
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

