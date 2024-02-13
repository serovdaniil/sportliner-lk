package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.BranchOfficeItemDto;
import by.sportliner.lk.endpoint.api.PayingEntityDto;
import by.sportliner.lk.endpoint.api.PaymentTypeDto;
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

  @JsonProperty("tariff")
  private TariffDto tariff;

  @JsonProperty("invoiceNumber")
  private String invoiceNumber;

  @JsonProperty("paymentType")
  private PaymentTypeDto paymentType;

  @JsonProperty("payingEntity")
  private PayingEntityDto payingEntity;

  @JsonProperty("benefits")
  private Boolean benefits;

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
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
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

  public ChildDto tariff(TariffDto tariff) {
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

  public ChildDto invoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
    return this;
  }

  /**
   * Get invoiceNumber
   * @return invoiceNumber
  */
  
  @Schema(name = "invoiceNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
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

  public ChildDto payingEntity(PayingEntityDto payingEntity) {
    this.payingEntity = payingEntity;
    return this;
  }

  /**
   * Get payingEntity
   * @return payingEntity
  */
  @NotNull @Valid 
  @Schema(name = "payingEntity", requiredMode = Schema.RequiredMode.REQUIRED)
  public PayingEntityDto getPayingEntity() {
    return payingEntity;
  }

  public void setPayingEntity(PayingEntityDto payingEntity) {
    this.payingEntity = payingEntity;
  }

  public ChildDto benefits(Boolean benefits) {
    this.benefits = benefits;
    return this;
  }

  /**
   * Get benefits
   * @return benefits
  */
  @NotNull 
  @Schema(name = "benefits", requiredMode = Schema.RequiredMode.REQUIRED)
  public Boolean isBenefits() {
    return benefits;
  }

  public void setBenefits(Boolean benefits) {
    this.benefits = benefits;
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
        Objects.equals(this.tariff, child.tariff) &&
        Objects.equals(this.invoiceNumber, child.invoiceNumber) &&
        Objects.equals(this.paymentType, child.paymentType) &&
        Objects.equals(this.payingEntity, child.payingEntity) &&
        Objects.equals(this.benefits, child.benefits) &&
        Objects.equals(this.notes, child.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastName, branchOffice, firstName, patronymic, birthdate, diagnosis, tuitionBalance, tariff, invoiceNumber, paymentType, payingEntity, benefits, notes);
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
    sb.append("    tariff: ").append(toIndentedString(tariff)).append("\n");
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
    sb.append("    paymentType: ").append(toIndentedString(paymentType)).append("\n");
    sb.append("    payingEntity: ").append(toIndentedString(payingEntity)).append("\n");
    sb.append("    benefits: ").append(toIndentedString(benefits)).append("\n");
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

