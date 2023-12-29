package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.ChildInfoDto;
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
 * User account
 */

@Schema(name = "UserProfile", description = "User account")
@JsonTypeName("UserProfile")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserProfileDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("username")
  private String username;

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

  @JsonProperty("children")
  @Valid
  private List<ChildInfoDto> children = null;

  public UserProfileDto id(String id) {
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

  public UserProfileDto username(String username) {
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

  public UserProfileDto email(String email) {
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

  public UserProfileDto phone(String phone) {
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

  public UserProfileDto firstName(String firstName) {
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

  public UserProfileDto patronymic(String patronymic) {
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

  public UserProfileDto lastName(String lastName) {
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

  public UserProfileDto children(List<ChildInfoDto> children) {
    this.children = children;
    return this;
  }

  public UserProfileDto addChildrenItem(ChildInfoDto childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * Children who will attend the classes
   * @return children
  */
  @Valid 
  @Schema(name = "children", description = "Children who will attend the classes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<ChildInfoDto> getChildren() {
    return children;
  }

  public void setChildren(List<ChildInfoDto> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserProfileDto userProfile = (UserProfileDto) o;
    return Objects.equals(this.id, userProfile.id) &&
        Objects.equals(this.username, userProfile.username) &&
        Objects.equals(this.email, userProfile.email) &&
        Objects.equals(this.phone, userProfile.phone) &&
        Objects.equals(this.firstName, userProfile.firstName) &&
        Objects.equals(this.patronymic, userProfile.patronymic) &&
        Objects.equals(this.lastName, userProfile.lastName) &&
        Objects.equals(this.children, userProfile.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, phone, firstName, patronymic, lastName, children);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserProfileDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    patronymic: ").append(toIndentedString(patronymic)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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

