package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Analysis data
 */

@Schema(name = "AnalysisData", description = "Analysis data")
@JsonTypeName("AnalysisData")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AnalysisDataDto {

  @JsonProperty("averageAttendance")
  private BigDecimal averageAttendance;

  @JsonProperty("attendanceByTime")
  @Valid
  private Map<String, Integer> attendanceByTime = new HashMap<>();

  public AnalysisDataDto averageAttendance(BigDecimal averageAttendance) {
    this.averageAttendance = averageAttendance;
    return this;
  }

  /**
   * Average attendance
   * @return averageAttendance
  */
  @NotNull @Valid 
  @Schema(name = "averageAttendance", description = "Average attendance", requiredMode = Schema.RequiredMode.REQUIRED)
  public BigDecimal getAverageAttendance() {
    return averageAttendance;
  }

  public void setAverageAttendance(BigDecimal averageAttendance) {
    this.averageAttendance = averageAttendance;
  }

  public AnalysisDataDto attendanceByTime(Map<String, Integer> attendanceByTime) {
    this.attendanceByTime = attendanceByTime;
    return this;
  }

  public AnalysisDataDto putAttendanceByTimeItem(String key, Integer attendanceByTimeItem) {
    this.attendanceByTime.put(key, attendanceByTimeItem);
    return this;
  }

  /**
   * Attendance by time
   * @return attendanceByTime
  */
  @NotNull 
  @Schema(name = "attendanceByTime", description = "Attendance by time", requiredMode = Schema.RequiredMode.REQUIRED)
  public Map<String, Integer> getAttendanceByTime() {
    return attendanceByTime;
  }

  public void setAttendanceByTime(Map<String, Integer> attendanceByTime) {
    this.attendanceByTime = attendanceByTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalysisDataDto analysisData = (AnalysisDataDto) o;
    return Objects.equals(this.averageAttendance, analysisData.averageAttendance) &&
        Objects.equals(this.attendanceByTime, analysisData.attendanceByTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(averageAttendance, attendanceByTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalysisDataDto {\n");
    sb.append("    averageAttendance: ").append(toIndentedString(averageAttendance)).append("\n");
    sb.append("    attendanceByTime: ").append(toIndentedString(attendanceByTime)).append("\n");
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

