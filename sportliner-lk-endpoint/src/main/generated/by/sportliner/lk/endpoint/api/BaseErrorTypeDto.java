package by.sportliner.lk.endpoint.api;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets BaseErrorType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum BaseErrorTypeDto {
  
  AUTHENTICATION("AUTHENTICATION"),
  
  UNIQUENESS_VIOLATION("UNIQUENESS_VIOLATION"),
  
  REFERENCE_VIOLATION("REFERENCE_VIOLATION"),
  
  DATA_VALIDATION("DATA_VALIDATION"),
  
  OBJECT_NOT_FOUND("OBJECT_NOT_FOUND"),
  
  CLIENT_VERSION_REJECTED("CLIENT_VERSION_REJECTED"),
  
  INTEGRATION("INTEGRATION"),
  
  INTERNAL("INTERNAL");

  private String value;

  BaseErrorTypeDto(String value) {
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
  public static BaseErrorTypeDto fromValue(String value) {
    for (BaseErrorTypeDto b : BaseErrorTypeDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

