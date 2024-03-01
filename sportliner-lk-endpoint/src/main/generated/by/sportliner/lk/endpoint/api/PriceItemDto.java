package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.PriceItemTypeDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Price item
 */

@Schema(name = "PriceItem", description = "Price item")
@JsonTypeName("PriceItem")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PriceItemDto {

  @JsonProperty("type")
  private PriceItemTypeDto type;

  @JsonProperty("normalPrice")
  private BigDecimal normalPrice;

  @JsonProperty("benefitsPrice")
  private BigDecimal benefitsPrice;

  public PriceItemDto type(PriceItemTypeDto type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  public PriceItemTypeDto getType() {
    return type;
  }

  public void setType(PriceItemTypeDto type) {
    this.type = type;
  }

  public PriceItemDto normalPrice(BigDecimal normalPrice) {
    this.normalPrice = normalPrice;
    return this;
  }

  /**
   * Normal price
   * @return normalPrice
  */
  @NotNull @Valid 
  @Schema(name = "normalPrice", description = "Normal price", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getNormalPrice() {
    return normalPrice;
  }

  public void setNormalPrice(BigDecimal normalPrice) {
    this.normalPrice = normalPrice;
  }

  public PriceItemDto benefitsPrice(BigDecimal benefitsPrice) {
    this.benefitsPrice = benefitsPrice;
    return this;
  }

  /**
   * Benefits price
   * @return benefitsPrice
  */
  @NotNull @Valid 
  @Schema(name = "benefitsPrice", description = "Benefits price", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getBenefitsPrice() {
    return benefitsPrice;
  }

  public void setBenefitsPrice(BigDecimal benefitsPrice) {
    this.benefitsPrice = benefitsPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceItemDto priceItem = (PriceItemDto) o;
    return Objects.equals(this.type, priceItem.type) &&
        Objects.equals(this.normalPrice, priceItem.normalPrice) &&
        Objects.equals(this.benefitsPrice, priceItem.benefitsPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, normalPrice, benefitsPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceItemDto {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    normalPrice: ").append(toIndentedString(normalPrice)).append("\n");
    sb.append("    benefitsPrice: ").append(toIndentedString(benefitsPrice)).append("\n");
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

