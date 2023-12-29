package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Credentials for authentication
 */

@Schema(name = "AuthChangePassword", description = "Credentials for authentication")
@JsonTypeName("AuthChangePassword")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AuthChangePasswordDto {

  @JsonProperty("username")
  private String username;

  @JsonProperty("oldPassword")
  private String oldPassword;

  @JsonProperty("newPassword")
  private String newPassword;

  public AuthChangePasswordDto username(String username) {
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

  public AuthChangePasswordDto oldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
    return this;
  }

  /**
   * Get oldPassword
   * @return oldPassword
  */
  @NotNull 
  @Schema(name = "oldPassword", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public AuthChangePasswordDto newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  /**
   * Get newPassword
   * @return newPassword
  */
  @NotNull 
  @Schema(name = "newPassword", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthChangePasswordDto authChangePassword = (AuthChangePasswordDto) o;
    return Objects.equals(this.username, authChangePassword.username) &&
        Objects.equals(this.oldPassword, authChangePassword.oldPassword) &&
        Objects.equals(this.newPassword, authChangePassword.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, oldPassword, newPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthChangePasswordDto {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    oldPassword: ").append(toIndentedString(oldPassword)).append("\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
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

