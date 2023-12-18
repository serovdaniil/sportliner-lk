package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.UserRoleDto;
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
 * UserAccountCriteriaDto
 */

@JsonTypeName("UserAccountCriteria")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserAccountCriteriaDto {

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("role")
  private UserRoleDto role;

  @JsonProperty("payAttention")
  private Boolean payAttention;

  public UserAccountCriteriaDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  
  @Schema(name = "lastName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserAccountCriteriaDto role(UserRoleDto role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
  */
  @Valid 
  @Schema(name = "role", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public UserRoleDto getRole() {
    return role;
  }

  public void setRole(UserRoleDto role) {
    this.role = role;
  }

  public UserAccountCriteriaDto payAttention(Boolean payAttention) {
    this.payAttention = payAttention;
    return this;
  }

  /**
   * Get payAttention
   * @return payAttention
  */
  
  @Schema(name = "payAttention", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Boolean isPayAttention() {
    return payAttention;
  }

  public void setPayAttention(Boolean payAttention) {
    this.payAttention = payAttention;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccountCriteriaDto userAccountCriteria = (UserAccountCriteriaDto) o;
    return Objects.equals(this.lastName, userAccountCriteria.lastName) &&
        Objects.equals(this.role, userAccountCriteria.role) &&
        Objects.equals(this.payAttention, userAccountCriteria.payAttention);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, role, payAttention);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAccountCriteriaDto {\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    payAttention: ").append(toIndentedString(payAttention)).append("\n");
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

