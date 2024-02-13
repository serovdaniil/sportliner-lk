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
 * Gets or Sets Tariff
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum TariffDto {
  
  ONE_LESSON_PER_WEEK("ONE_LESSON_PER_WEEK"),
  
  TWO_LESSONS_PER_WEEK("TWO_LESSONS_PER_WEEK"),
  
  THREE_LESSONS_PER_WEEK("THREE_LESSONS_PER_WEEK"),
  
  UNLIM("UNLIM");

  private String value;

  TariffDto(String value) {
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
  public static TariffDto fromValue(String value) {
    for (TariffDto b : TariffDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

