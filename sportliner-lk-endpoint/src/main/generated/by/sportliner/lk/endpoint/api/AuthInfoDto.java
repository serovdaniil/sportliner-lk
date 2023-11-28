package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
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
 * AuthInfoDto
 */

@JsonTypeName("AuthInfo")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AuthInfoDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("username")
  private String username;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("avatarId")
  private String avatarId;

  @JsonProperty("authorities")
  @Valid
  private List<String> authorities = new ArrayList<>();

  public AuthInfoDto id(String id) {
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

  public AuthInfoDto username(String username) {
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

  public AuthInfoDto firstName(String firstName) {
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

  public AuthInfoDto lastName(String lastName) {
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

  public AuthInfoDto avatarId(String avatarId) {
    this.avatarId = avatarId;
    return this;
  }

  /**
   * Get avatarId
   * @return avatarId
  */
  
  @Schema(name = "avatarId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getAvatarId() {
    return avatarId;
  }

  public void setAvatarId(String avatarId) {
    this.avatarId = avatarId;
  }

  public AuthInfoDto authorities(List<String> authorities) {
    this.authorities = authorities;
    return this;
  }

  public AuthInfoDto addAuthoritiesItem(String authoritiesItem) {
    this.authorities.add(authoritiesItem);
    return this;
  }

  /**
   * Get authorities
   * @return authorities
  */
  @NotNull 
  @Schema(name = "authorities", requiredMode = Schema.RequiredMode.REQUIRED)
  public List<String> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<String> authorities) {
    this.authorities = authorities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthInfoDto authInfo = (AuthInfoDto) o;
    return Objects.equals(this.id, authInfo.id) &&
        Objects.equals(this.username, authInfo.username) &&
        Objects.equals(this.firstName, authInfo.firstName) &&
        Objects.equals(this.lastName, authInfo.lastName) &&
        Objects.equals(this.avatarId, authInfo.avatarId) &&
        Objects.equals(this.authorities, authInfo.authorities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, firstName, lastName, avatarId, authorities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthInfoDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    avatarId: ").append(toIndentedString(avatarId)).append("\n");
    sb.append("    authorities: ").append(toIndentedString(authorities)).append("\n");
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

