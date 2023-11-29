package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.UserRoleDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * User account
 */

@Schema(name = "UserAccount", description = "User account")
@JsonTypeName("UserAccount")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserAccountDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  @JsonProperty("passwordMustBeChanged")
  private Boolean passwordMustBeChanged;

  @JsonProperty("role")
  private UserRoleDto role;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("patronymic")
  private String patronymic;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("createTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private java.time.Instant createTimestamp;

  @JsonProperty("updateTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private java.time.Instant updateTimestamp;

  @JsonProperty("loginTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private java.time.Instant loginTimestamp;

  public UserAccountDto id(String id) {
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

  public UserAccountDto username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  @NotNull 
  @Schema(name = "username", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserAccountDto password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  
  @Schema(name = "password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserAccountDto passwordMustBeChanged(Boolean passwordMustBeChanged) {
    this.passwordMustBeChanged = passwordMustBeChanged;
    return this;
  }

  /**
   * Get passwordMustBeChanged
   * @return passwordMustBeChanged
  */
  @NotNull 
  @Schema(name = "passwordMustBeChanged", requiredMode = Schema.RequiredMode.REQUIRED)
  public Boolean isPasswordMustBeChanged() {
    return passwordMustBeChanged;
  }

  public void setPasswordMustBeChanged(Boolean passwordMustBeChanged) {
    this.passwordMustBeChanged = passwordMustBeChanged;
  }

  public UserAccountDto role(UserRoleDto role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
  */
  @NotNull @Valid 
  @Schema(name = "role", requiredMode = Schema.RequiredMode.REQUIRED)
  public UserRoleDto getRole() {
    return role;
  }

  public void setRole(UserRoleDto role) {
    this.role = role;
  }

  public UserAccountDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull 
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserAccountDto phone(String phone) {
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

  public UserAccountDto firstName(String firstName) {
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

  public UserAccountDto patronymic(String patronymic) {
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

  public UserAccountDto lastName(String lastName) {
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

  public UserAccountDto createTimestamp(java.time.Instant createTimestamp) {
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

  public UserAccountDto updateTimestamp(java.time.Instant updateTimestamp) {
    this.updateTimestamp = updateTimestamp;
    return this;
  }

  /**
   * Get updateTimestamp
   * @return updateTimestamp
  */
  @Valid 
  @Schema(name = "updateTimestamp", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public java.time.Instant getUpdateTimestamp() {
    return updateTimestamp;
  }

  public void setUpdateTimestamp(java.time.Instant updateTimestamp) {
    this.updateTimestamp = updateTimestamp;
  }

  public UserAccountDto loginTimestamp(java.time.Instant loginTimestamp) {
    this.loginTimestamp = loginTimestamp;
    return this;
  }

  /**
   * Get loginTimestamp
   * @return loginTimestamp
  */
  @Valid 
  @Schema(name = "loginTimestamp", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public java.time.Instant getLoginTimestamp() {
    return loginTimestamp;
  }

  public void setLoginTimestamp(java.time.Instant loginTimestamp) {
    this.loginTimestamp = loginTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccountDto userAccount = (UserAccountDto) o;
    return Objects.equals(this.id, userAccount.id) &&
        Objects.equals(this.username, userAccount.username) &&
        Objects.equals(this.password, userAccount.password) &&
        Objects.equals(this.passwordMustBeChanged, userAccount.passwordMustBeChanged) &&
        Objects.equals(this.role, userAccount.role) &&
        Objects.equals(this.email, userAccount.email) &&
        Objects.equals(this.phone, userAccount.phone) &&
        Objects.equals(this.firstName, userAccount.firstName) &&
        Objects.equals(this.patronymic, userAccount.patronymic) &&
        Objects.equals(this.lastName, userAccount.lastName) &&
        Objects.equals(this.createTimestamp, userAccount.createTimestamp) &&
        Objects.equals(this.updateTimestamp, userAccount.updateTimestamp) &&
        Objects.equals(this.loginTimestamp, userAccount.loginTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, passwordMustBeChanged, role, email, phone, firstName, patronymic, lastName, createTimestamp, updateTimestamp, loginTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAccountDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    passwordMustBeChanged: ").append(toIndentedString(passwordMustBeChanged)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    patronymic: ").append(toIndentedString(patronymic)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    createTimestamp: ").append(toIndentedString(createTimestamp)).append("\n");
    sb.append("    updateTimestamp: ").append(toIndentedString(updateTimestamp)).append("\n");
    sb.append("    loginTimestamp: ").append(toIndentedString(loginTimestamp)).append("\n");
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

