package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DataValidationErrorItemDto
 */

@JsonTypeName("DataValidationErrorItem")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class DataValidationErrorItemDto {

  @JsonProperty("sheet")
  private String sheet;

  @JsonProperty("cell")
  private String cell;

  @JsonProperty("message")
  private String message;

  public DataValidationErrorItemDto sheet(String sheet) {
    this.sheet = sheet;
    return this;
  }

  /**
   * Get sheet
   * @return sheet
  */
  
  @Schema(name = "sheet", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSheet() {
    return sheet;
  }

  public void setSheet(String sheet) {
    this.sheet = sheet;
  }

  public DataValidationErrorItemDto cell(String cell) {
    this.cell = cell;
    return this;
  }

  /**
   * Get cell
   * @return cell
  */
  
  @Schema(name = "cell", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCell() {
    return cell;
  }

  public void setCell(String cell) {
    this.cell = cell;
  }

  public DataValidationErrorItemDto message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataValidationErrorItemDto dataValidationErrorItem = (DataValidationErrorItemDto) o;
    return Objects.equals(this.sheet, dataValidationErrorItem.sheet) &&
        Objects.equals(this.cell, dataValidationErrorItem.cell) &&
        Objects.equals(this.message, dataValidationErrorItem.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sheet, cell, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataValidationErrorItemDto {\n");
    sb.append("    sheet: ").append(toIndentedString(sheet)).append("\n");
    sb.append("    cell: ").append(toIndentedString(cell)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

