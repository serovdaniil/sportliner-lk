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
 * Price item type
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum PriceItemTypeDto {
  
  ONE_LESSON("ONE_LESSON"),
  
  TWO_LESSONS("TWO_LESSONS"),
  
  THREE_LESSONS("THREE_LESSONS"),
  
  FOUR_LESSONS("FOUR_LESSONS"),
  
  FIVE_LESSONS("FIVE_LESSONS"),
  
  SIX_LESSONS("SIX_LESSONS"),
  
  SEVEN_LESSONS("SEVEN_LESSONS"),
  
  EIGHT_LESSONS("EIGHT_LESSONS"),
  
  NINE_LESSONS("NINE_LESSONS"),
  
  TEN_LESSONS("TEN_LESSONS"),
  
  ELEVEN_LESSONS("ELEVEN_LESSONS"),
  
  TWELVE_LESSONS("TWELVE_LESSONS"),
  
  UNLIM("UNLIM");

  private String value;

  PriceItemTypeDto(String value) {
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
  public static PriceItemTypeDto fromValue(String value) {
    for (PriceItemTypeDto b : PriceItemTypeDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

