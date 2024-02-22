package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.TaskStatusDto;
import by.sportliner.lk.endpoint.api.UserAccountItemDto;
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
 * Task
 */

@Schema(name = "Task", description = "Task")
@JsonTypeName("Task")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TaskDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("assignee")
  private UserAccountItemDto assignee;

  @JsonProperty("reporter")
  private UserAccountItemDto reporter;

  @JsonProperty("status")
  private TaskStatusDto status;

  public TaskDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID
   * @return id
  */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TaskDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Name", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TaskDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description
   * @return description
  */
  @NotNull 
  @Schema(name = "description", description = "Description", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskDto assignee(UserAccountItemDto assignee) {
    this.assignee = assignee;
    return this;
  }

  /**
   * Get assignee
   * @return assignee
  */
  @NotNull @Valid 
  @Schema(name = "assignee", requiredMode = Schema.RequiredMode.REQUIRED)
  public UserAccountItemDto getAssignee() {
    return assignee;
  }

  public void setAssignee(UserAccountItemDto assignee) {
    this.assignee = assignee;
  }

  public TaskDto reporter(UserAccountItemDto reporter) {
    this.reporter = reporter;
    return this;
  }

  /**
   * Get reporter
   * @return reporter
  */
  @NotNull @Valid 
  @Schema(name = "reporter", requiredMode = Schema.RequiredMode.REQUIRED)
  public UserAccountItemDto getReporter() {
    return reporter;
  }

  public void setReporter(UserAccountItemDto reporter) {
    this.reporter = reporter;
  }

  public TaskDto status(TaskStatusDto status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  public TaskStatusDto getStatus() {
    return status;
  }

  public void setStatus(TaskStatusDto status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDto task = (TaskDto) o;
    return Objects.equals(this.id, task.id) &&
        Objects.equals(this.name, task.name) &&
        Objects.equals(this.description, task.description) &&
        Objects.equals(this.assignee, task.assignee) &&
        Objects.equals(this.reporter, task.reporter) &&
        Objects.equals(this.status, task.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, assignee, reporter, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
    sb.append("    reporter: ").append(toIndentedString(reporter)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

