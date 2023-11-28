package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.DataValidationErrorItemDto;
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
 * DataValidationErrorAllOfDto
 */

@JsonTypeName("DataValidationError_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class DataValidationErrorAllOfDto {

  @JsonProperty("details")
  @Valid
  private List<DataValidationErrorItemDto> details = null;

  public DataValidationErrorAllOfDto details(List<DataValidationErrorItemDto> details) {
    this.details = details;
    return this;
  }

  public DataValidationErrorAllOfDto addDetailsItem(DataValidationErrorItemDto detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * Get details
   * @return details
  */
  @Valid 
  @Schema(name = "details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DataValidationErrorItemDto> getDetails() {
    return details;
  }

  public void setDetails(List<DataValidationErrorItemDto> details) {
    this.details = details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataValidationErrorAllOfDto dataValidationErrorAllOf = (DataValidationErrorAllOfDto) o;
    return Objects.equals(this.details, dataValidationErrorAllOf.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataValidationErrorAllOfDto {\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

