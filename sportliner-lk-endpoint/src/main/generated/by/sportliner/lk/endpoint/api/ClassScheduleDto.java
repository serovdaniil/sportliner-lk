package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.DayOfWeekDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Class schedule
 */

@Schema(name = "ClassSchedule", description = "Class schedule")
@JsonTypeName("ClassSchedule")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ClassScheduleDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("day")
  private DayOfWeekDto day;

  @JsonProperty("time")
  private java.time.LocalTime time;

  public ClassScheduleDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.REQUIRED)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ClassScheduleDto day(DayOfWeekDto day) {
    this.day = day;
    return this;
  }

  /**
   * Get day
   * @return day
  */
  @NotNull @Valid 
  @Schema(name = "day", requiredMode = Schema.RequiredMode.REQUIRED)
  public DayOfWeekDto getDay() {
    return day;
  }

  public void setDay(DayOfWeekDto day) {
    this.day = day;
  }

  public ClassScheduleDto time(java.time.LocalTime time) {
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
    ClassScheduleDto classSchedule = (ClassScheduleDto) o;
    return Objects.equals(this.id, classSchedule.id) &&
        Objects.equals(this.day, classSchedule.day) &&
        Objects.equals(this.time, classSchedule.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, day, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassScheduleDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
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

