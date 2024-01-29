package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.BranchOfficeItemDto;
import by.sportliner.lk.endpoint.api.TrialAttendanceStatusDto;
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
 * Trial attendance
 */

@Schema(name = "TrialAttendance", description = "Trial attendance")
@JsonTypeName("TrialAttendance")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TrialAttendanceDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("telegramUsername")
  private String telegramUsername;

  @JsonProperty("branchOffice")
  private BranchOfficeItemDto branchOffice;

  @JsonProperty("name")
  private String name;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("diagnosis")
  private String diagnosis;

  @JsonProperty("date")
  private java.time.LocalDate date;

  @JsonProperty("status")
  private TrialAttendanceStatusDto status;

  public TrialAttendanceDto id(String id) {
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

  public TrialAttendanceDto telegramUsername(String telegramUsername) {
    this.telegramUsername = telegramUsername;
    return this;
  }

  /**
   * Get telegramUsername
   * @return telegramUsername
  */
  
  @Schema(name = "telegramUsername", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getTelegramUsername() {
    return telegramUsername;
  }

  public void setTelegramUsername(String telegramUsername) {
    this.telegramUsername = telegramUsername;
  }

  public TrialAttendanceDto branchOffice(BranchOfficeItemDto branchOffice) {
    this.branchOffice = branchOffice;
    return this;
  }

  /**
   * Get branchOffice
   * @return branchOffice
  */
  @NotNull @Valid 
  @Schema(name = "branchOffice", requiredMode = Schema.RequiredMode.REQUIRED)
  public BranchOfficeItemDto getBranchOffice() {
    return branchOffice;
  }

  public void setBranchOffice(BranchOfficeItemDto branchOffice) {
    this.branchOffice = branchOffice;
  }

  public TrialAttendanceDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TrialAttendanceDto phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @NotNull 
  @Schema(name = "phone", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public TrialAttendanceDto diagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
    return this;
  }

  /**
   * Get diagnosis
   * @return diagnosis
  */
  @NotNull 
  @Schema(name = "diagnosis", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  public TrialAttendanceDto date(java.time.LocalDate date) {
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

  public TrialAttendanceDto status(TrialAttendanceStatusDto status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  public TrialAttendanceStatusDto getStatus() {
    return status;
  }

  public void setStatus(TrialAttendanceStatusDto status) {
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
    TrialAttendanceDto trialAttendance = (TrialAttendanceDto) o;
    return Objects.equals(this.id, trialAttendance.id) &&
        Objects.equals(this.telegramUsername, trialAttendance.telegramUsername) &&
        Objects.equals(this.branchOffice, trialAttendance.branchOffice) &&
        Objects.equals(this.name, trialAttendance.name) &&
        Objects.equals(this.phone, trialAttendance.phone) &&
        Objects.equals(this.diagnosis, trialAttendance.diagnosis) &&
        Objects.equals(this.date, trialAttendance.date) &&
        Objects.equals(this.status, trialAttendance.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, telegramUsername, branchOffice, name, phone, diagnosis, date, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrialAttendanceDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    telegramUsername: ").append(toIndentedString(telegramUsername)).append("\n");
    sb.append("    branchOffice: ").append(toIndentedString(branchOffice)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    diagnosis: ").append(toIndentedString(diagnosis)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

