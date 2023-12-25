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

@Schema(name = "Attendance", description = "Child attendance")
@JsonTypeName("Attendance")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AttendanceDto {

  @JsonProperty("date")
  private java.time.LocalDate date;

  @JsonProperty("time")
  private java.time.LocalTime time;

  public AttendanceDto date(java.time.LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @NotNull @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.REQUIRED)
  public java.time.LocalDate getDate() {
    return date;
  }

  public void setDate(java.time.LocalDate date) {
    this.date = date;
  }

  public AttendanceDto time(java.time.LocalTime time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  */
  @NotNull @Valid 
  @Schema(name = "time", requiredMode = Schema.RequiredMode.REQUIRED)
  public java.time.LocalTime getTime() {
    return time;
  }

  public void setTime(java.time.LocalTime time) {
    this.time = time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttendanceDto attendance = (AttendanceDto) o;
    return Objects.equals(this.date, attendance.date) &&
        Objects.equals(this.time, attendance.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttendanceDto {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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

