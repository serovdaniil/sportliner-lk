package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.BranchOfficeItemDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Telegram bot application
 */

@Schema(name = "TelegramBotApplication", description = "Telegram bot application")
@JsonTypeName("TelegramBotApplication")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TelegramBotApplicationDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("telegramUsername")
  private String telegramUsername;

  @JsonProperty("createTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private java.time.Instant createTimestamp;

  @JsonProperty("branchOffice")
  private BranchOfficeItemDto branchOffice;

  @JsonProperty("phone")
  private String phone;

  public TelegramBotApplicationDto id(String id) {
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

  public TelegramBotApplicationDto telegramUsername(String telegramUsername) {
    this.telegramUsername = telegramUsername;
    return this;
  }

  /**
   * Telegram username
   * @return telegramUsername
  */
  @NotNull 
  @Schema(name = "telegramUsername", description = "Telegram username", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getTelegramUsername() {
    return telegramUsername;
  }

  public void setTelegramUsername(String telegramUsername) {
    this.telegramUsername = telegramUsername;
  }

  public TelegramBotApplicationDto createTimestamp(java.time.Instant createTimestamp) {
    this.createTimestamp = createTimestamp;
    return this;
  }

  /**
   * Get createTimestamp
   * @return createTimestamp
  */
  @Valid 
  @Schema(name = "createTimestamp", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.REQUIRED)
  public java.time.Instant getCreateTimestamp() {
    return createTimestamp;
  }

  public void setCreateTimestamp(java.time.Instant createTimestamp) {
    this.createTimestamp = createTimestamp;
  }

  public TelegramBotApplicationDto branchOffice(BranchOfficeItemDto branchOffice) {
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

  public TelegramBotApplicationDto phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Phone
   * @return phone
  */
  
  @Schema(name = "phone", description = "Phone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TelegramBotApplicationDto telegramBotApplication = (TelegramBotApplicationDto) o;
    return Objects.equals(this.id, telegramBotApplication.id) &&
        Objects.equals(this.telegramUsername, telegramBotApplication.telegramUsername) &&
        Objects.equals(this.createTimestamp, telegramBotApplication.createTimestamp) &&
        Objects.equals(this.branchOffice, telegramBotApplication.branchOffice) &&
        Objects.equals(this.phone, telegramBotApplication.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, telegramUsername, createTimestamp, branchOffice, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TelegramBotApplicationDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    telegramUsername: ").append(toIndentedString(telegramUsername)).append("\n");
    sb.append("    createTimestamp: ").append(toIndentedString(createTimestamp)).append("\n");
    sb.append("    branchOffice: ").append(toIndentedString(branchOffice)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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

