package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.AttendanceDto;
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
 * Child attendance
 */

@Schema(name = "ChildAttendance", description = "Child attendance")
@JsonTypeName("ChildAttendance")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ChildAttendanceDto {

  @JsonProperty("childId")
  private String childId;

  @JsonProperty("attendances")
  @Valid
  private List<AttendanceDto> attendances = new ArrayList<>();

  public ChildAttendanceDto childId(String childId) {
    this.childId = childId;
    return this;
  }

  /**
   * Child ID
   * @return childId
  */
  @NotNull 
  @Schema(name = "childId", description = "Child ID", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getChildId() {
    return childId;
  }

  public void setChildId(String childId) {
    this.childId = childId;
  }

  public ChildAttendanceDto attendances(List<AttendanceDto> attendances) {
    this.attendances = attendances;
    return this;
  }

  public ChildAttendanceDto addAttendancesItem(AttendanceDto attendancesItem) {
    this.attendances.add(attendancesItem);
    return this;
  }

  /**
   * Attendances
   * @return attendances
  */
  @NotNull @Valid 
  @Schema(name = "attendances", description = "Attendances", requiredMode = Schema.RequiredMode.REQUIRED)
  public List<AttendanceDto> getAttendances() {
    return attendances;
  }

  public void setAttendances(List<AttendanceDto> attendances) {
    this.attendances = attendances;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChildAttendanceDto childAttendance = (ChildAttendanceDto) o;
    return Objects.equals(this.childId, childAttendance.childId) &&
        Objects.equals(this.attendances, childAttendance.attendances);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childId, attendances);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildAttendanceDto {\n");
    sb.append("    childId: ").append(toIndentedString(childId)).append("\n");
    sb.append("    attendances: ").append(toIndentedString(attendances)).append("\n");
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

