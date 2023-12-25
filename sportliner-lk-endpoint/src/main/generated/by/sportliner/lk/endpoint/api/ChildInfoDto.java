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
 * Child attendance
 */

@Schema(name = "ChildInfo", description = "Child attendance")
@JsonTypeName("ChildInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ChildInfoDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("fullName")
  private String fullName;

  public ChildInfoDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ChildInfoDto fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * fullName
   * @return fullName
  */
  @NotNull 
  @Schema(name = "fullName", description = "fullName", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChildInfoDto childInfo = (ChildInfoDto) o;
    return Objects.equals(this.id, childInfo.id) &&
        Objects.equals(this.fullName, childInfo.fullName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fullName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildInfoDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
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

