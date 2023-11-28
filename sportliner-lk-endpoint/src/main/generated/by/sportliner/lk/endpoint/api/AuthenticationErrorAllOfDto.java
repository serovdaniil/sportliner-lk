package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
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
 * AuthenticationErrorAllOfDto
 */

@JsonTypeName("AuthenticationError_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AuthenticationErrorAllOfDto {

  /**
   * Error reason
   */
  public enum ReasonEnum {
    INVALID_CREDENTIALS("INVALID_CREDENTIALS"),
    
    ACCOUNT_BLOCKED("ACCOUNT_BLOCKED"),
    
    INSUFFICIENT_PRIVILEGES("INSUFFICIENT_PRIVILEGES");

    private String value;

    ReasonEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ReasonEnum fromValue(String value) {
      for (ReasonEnum b : ReasonEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("reason")
  private ReasonEnum reason;

  public AuthenticationErrorAllOfDto reason(ReasonEnum reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Error reason
   * @return reason
  */
  @NotNull 
  @Schema(name = "reason", description = "Error reason", requiredMode = Schema.RequiredMode.REQUIRED)
  public ReasonEnum getReason() {
    return reason;
  }

  public void setReason(ReasonEnum reason) {
    this.reason = reason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationErrorAllOfDto authenticationErrorAllOf = (AuthenticationErrorAllOfDto) o;
    return Objects.equals(this.reason, authenticationErrorAllOf.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationErrorAllOfDto {\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

