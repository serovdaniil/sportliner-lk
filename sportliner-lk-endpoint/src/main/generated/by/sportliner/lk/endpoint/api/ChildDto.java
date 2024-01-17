package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.BranchOfficeItemDto;
import by.sportliner.lk.endpoint.api.PaymentTypeDto;
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

@Schema(name = "Child", description = "Child")
@JsonTypeName("Child")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ChildDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("branchOffice")
  private BranchOfficeItemDto branchOffice;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("patronymic")
  private String patronymic;

  @JsonProperty("birthdate")
  private java.time.LocalDate birthdate;

  @JsonProperty("diagnosis")
  private String diagnosis;

  @JsonProperty("tuitionBalance")
  private Integer tuitionBalance;

  @JsonProperty("numberClassesPerMonth")
  private Integer numberClassesPerMonth;

  @JsonProperty("paymentType")
  private PaymentTypeDto paymentType;

  @JsonProperty("notes")
  private String notes;

  public ChildDto id(String id) {
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

  public ChildDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @NotNull 
  @Schema(name = "lastName", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ChildDto branchOffice(BranchOfficeItemDto branchOffice) {
    this.branchOffice = branchOffice;
    return this;
  }

  /**
   * Get branchOffice
   * @return branchOffice
  */
  @Valid 
  @Schema(name = "branchOffice", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public BranchOfficeItemDto getBranchOffice() {
    return branchOffice;
  }

  public void setBranchOffice(BranchOfficeItemDto branchOffice) {
    this.branchOffice = branchOffice;
  }

  public ChildDto firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @NotNull 
  @Schema(name = "firstName", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ChildDto patronymic(String patronymic) {
    this.patronymic = patronymic;
    return this;
  }

  /**
   * Get patronymic
   * @return patronymic
  */
  @NotNull 
  @Schema(name = "patronymic", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public ChildDto birthdate(java.time.LocalDate birthdate) {
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

  public ChildDto diagnosis(String diagnosis) {
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

  public ChildDto tuitionBalance(Integer tuitionBalance) {
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

  public ChildDto numberClassesPerMonth(Integer numberClassesPerMonth) {
    this.numberClassesPerMonth = numberClassesPerMonth;
    return this;
  }

  /**
   * Get numberClassesPerMonth
   * @return numberClassesPerMonth
  */
  @NotNull 
  @Schema(name = "numberClassesPerMonth", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getNumberClassesPerMonth() {
    return numberClassesPerMonth;
  }

  public void setNumberClassesPerMonth(Integer numberClassesPerMonth) {
    this.numberClassesPerMonth = numberClassesPerMonth;
  }

  public ChildDto paymentType(PaymentTypeDto paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * Get paymentType
   * @return paymentType
  */
  @NotNull @Valid 
  @Schema(name = "paymentType", requiredMode = Schema.RequiredMode.REQUIRED)
  public PaymentTypeDto getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentTypeDto paymentType) {
    this.paymentType = paymentType;
  }

  public ChildDto notes(String notes) {
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
    ChildDto child = (ChildDto) o;
    return Objects.equals(this.id, child.id) &&
        Objects.equals(this.lastName, child.lastName) &&
        Objects.equals(this.branchOffice, child.branchOffice) &&
        Objects.equals(this.firstName, child.firstName) &&
        Objects.equals(this.patronymic, child.patronymic) &&
        Objects.equals(this.birthdate, child.birthdate) &&
        Objects.equals(this.diagnosis, child.diagnosis) &&
        Objects.equals(this.tuitionBalance, child.tuitionBalance) &&
        Objects.equals(this.numberClassesPerMonth, child.numberClassesPerMonth) &&
        Objects.equals(this.paymentType, child.paymentType) &&
        Objects.equals(this.notes, child.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastName, branchOffice, firstName, patronymic, birthdate, diagnosis, tuitionBalance, numberClassesPerMonth, paymentType, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    branchOffice: ").append(toIndentedString(branchOffice)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    patronymic: ").append(toIndentedString(patronymic)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    diagnosis: ").append(toIndentedString(diagnosis)).append("\n");
    sb.append("    tuitionBalance: ").append(toIndentedString(tuitionBalance)).append("\n");
    sb.append("    numberClassesPerMonth: ").append(toIndentedString(numberClassesPerMonth)).append("\n");
    sb.append("    paymentType: ").append(toIndentedString(paymentType)).append("\n");
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

