package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import by.sportliner.lk.endpoint.api.AuthInfoDto;
import by.sportliner.lk.endpoint.api.AuthTokenDto;
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
 * Authentication response
 */

@Schema(name = "AuthResponse", description = "Authentication response")
@JsonTypeName("AuthResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AuthResponseDto {

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    SUCCESS("SUCCESS"),
    
    MUST_CHANGE_PASSWORD("MUST_CHANGE_PASSWORD");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  @JsonProperty("token")
  private AuthTokenDto token;

  @JsonProperty("info")
  private AuthInfoDto info;

  @JsonProperty("sessionTimeout")
  private Integer sessionTimeout;

  public AuthResponseDto status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public AuthResponseDto token(AuthTokenDto token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  */
  @Valid 
  @Schema(name = "token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public AuthTokenDto getToken() {
    return token;
  }

  public void setToken(AuthTokenDto token) {
    this.token = token;
  }

  public AuthResponseDto info(AuthInfoDto info) {
    this.info = info;
    return this;
  }

  /**
   * Get info
   * @return info
  */
  @Valid 
  @Schema(name = "info", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public AuthInfoDto getInfo() {
    return info;
  }

  public void setInfo(AuthInfoDto info) {
    this.info = info;
  }

  public AuthResponseDto sessionTimeout(Integer sessionTimeout) {
    this.sessionTimeout = sessionTimeout;
    return this;
  }

  /**
   * Get sessionTimeout
   * @return sessionTimeout
  */
  @NotNull 
  @Schema(name = "sessionTimeout", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getSessionTimeout() {
    return sessionTimeout;
  }

  public void setSessionTimeout(Integer sessionTimeout) {
    this.sessionTimeout = sessionTimeout;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthResponseDto authResponse = (AuthResponseDto) o;
    return Objects.equals(this.status, authResponse.status) &&
        Objects.equals(this.token, authResponse.token) &&
        Objects.equals(this.info, authResponse.info) &&
        Objects.equals(this.sessionTimeout, authResponse.sessionTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, token, info, sessionTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthResponseDto {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
    sb.append("    sessionTimeout: ").append(toIndentedString(sessionTimeout)).append("\n");
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

