package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.BranchOfficeAddressDto;
import by.sportliner.lk.endpoint.api.ClassScheduleDto;
import by.sportliner.lk.endpoint.api.UserAccountItemDto;
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
 * Branch office
 */

@Schema(name = "BranchOffice", description = "Branch office")
@JsonTypeName("BranchOffice")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class BranchOfficeDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("address")
  private BranchOfficeAddressDto address;

  @JsonProperty("trainer")
  private UserAccountItemDto trainer;

  @JsonProperty("classSchedules")
  @Valid
  private List<ClassScheduleDto> classSchedules = null;

  public BranchOfficeDto id(String id) {
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

  public BranchOfficeDto name(String name) {
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

  public BranchOfficeDto address(BranchOfficeAddressDto address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @NotNull @Valid 
  @Schema(name = "address", requiredMode = Schema.RequiredMode.REQUIRED)
  public BranchOfficeAddressDto getAddress() {
    return address;
  }

  public void setAddress(BranchOfficeAddressDto address) {
    this.address = address;
  }

  public BranchOfficeDto trainer(UserAccountItemDto trainer) {
    this.trainer = trainer;
    return this;
  }

  /**
   * Get trainer
   * @return trainer
  */
  @NotNull @Valid 
  @Schema(name = "trainer", requiredMode = Schema.RequiredMode.REQUIRED)
  public UserAccountItemDto getTrainer() {
    return trainer;
  }

  public void setTrainer(UserAccountItemDto trainer) {
    this.trainer = trainer;
  }

  public BranchOfficeDto classSchedules(List<ClassScheduleDto> classSchedules) {
    this.classSchedules = classSchedules;
    return this;
  }

  public BranchOfficeDto addClassSchedulesItem(ClassScheduleDto classSchedulesItem) {
    if (this.classSchedules == null) {
      this.classSchedules = new ArrayList<>();
    }
    this.classSchedules.add(classSchedulesItem);
    return this;
  }

  /**
   * Class schedules
   * @return classSchedules
  */
  @Valid 
  @Schema(name = "classSchedules", description = "Class schedules", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<ClassScheduleDto> getClassSchedules() {
    return classSchedules;
  }

  public void setClassSchedules(List<ClassScheduleDto> classSchedules) {
    this.classSchedules = classSchedules;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BranchOfficeDto branchOffice = (BranchOfficeDto) o;
    return Objects.equals(this.id, branchOffice.id) &&
        Objects.equals(this.name, branchOffice.name) &&
        Objects.equals(this.address, branchOffice.address) &&
        Objects.equals(this.trainer, branchOffice.trainer) &&
        Objects.equals(this.classSchedules, branchOffice.classSchedules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, trainer, classSchedules);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BranchOfficeDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    trainer: ").append(toIndentedString(trainer)).append("\n");
    sb.append("    classSchedules: ").append(toIndentedString(classSchedules)).append("\n");
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

