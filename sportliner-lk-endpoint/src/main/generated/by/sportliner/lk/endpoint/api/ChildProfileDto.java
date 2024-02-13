package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.TariffDto;
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
 * Child
 */

@Schema(name = "ChildProfile", description = "Child")
@JsonTypeName("ChildProfile")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ChildProfileDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("fullName")
  private String fullName;

  @JsonProperty("birthdate")
  private java.time.LocalDate birthdate;

  @JsonProperty("diagnosis")
  private String diagnosis;

  @JsonProperty("tuitionBalance")
  private Integer tuitionBalance;

  @JsonProperty("tariff")
  private TariffDto tariff;

  @JsonProperty("notes")
  private String notes;

  public ChildProfileDto id(String id) {
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

  public ChildProfileDto fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Get fullName
   * @return fullName
  */
  @NotNull 
  @Schema(name = "fullName", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public ChildProfileDto birthdate(java.time.LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Get birthdate
   * @return birthdate
  */
  @Valid 
  @Schema(name = "birthdate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public java.time.LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(java.time.LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public ChildProfileDto diagnosis(String diagnosis) {
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

  public ChildProfileDto tuitionBalance(Integer tuitionBalance) {
    this.tuitionBalance = tuitionBalance;
    return this;
  }

  /**
   * Get tuitionBalance
   * @return tuitionBalance
  */
  @NotNull 
  @Schema(name = "tuitionBalance", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getTuitionBalance() {
    return tuitionBalance;
  }

  public void setTuitionBalance(Integer tuitionBalance) {
    this.tuitionBalance = tuitionBalance;
  }

  public ChildProfileDto tariff(TariffDto tariff) {
    this.tariff = tariff;
    return this;
  }

  /**
   * Get tariff
   * @return tariff
  */
  @NotNull @Valid 
  @Schema(name = "tariff", requiredMode = Schema.RequiredMode.REQUIRED)
  public TariffDto getTariff() {
    return tariff;
  }

  public void setTariff(TariffDto tariff) {
    this.tariff = tariff;
  }

  public ChildProfileDto notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * Get notes
   * @return notes
  */
  
  @Schema(name = "notes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChildProfileDto childProfile = (ChildProfileDto) o;
    return Objects.equals(this.id, childProfile.id) &&
        Objects.equals(this.fullName, childProfile.fullName) &&
        Objects.equals(this.birthdate, childProfile.birthdate) &&
        Objects.equals(this.diagnosis, childProfile.diagnosis) &&
        Objects.equals(this.tuitionBalance, childProfile.tuitionBalance) &&
        Objects.equals(this.tariff, childProfile.tariff) &&
        Objects.equals(this.notes, childProfile.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fullName, birthdate, diagnosis, tuitionBalance, tariff, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildProfileDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    diagnosis: ").append(toIndentedString(diagnosis)).append("\n");
    sb.append("    tuitionBalance: ").append(toIndentedString(tuitionBalance)).append("\n");
    sb.append("    tariff: ").append(toIndentedString(tariff)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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

