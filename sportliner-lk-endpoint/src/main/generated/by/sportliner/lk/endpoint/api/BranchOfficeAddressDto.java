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
 * Branch office address
 */

@Schema(name = "BranchOfficeAddress", description = "Branch office address")
@JsonTypeName("BranchOfficeAddress")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class BranchOfficeAddressDto {

  @JsonProperty("city")
  private String city;

  @JsonProperty("street")
  private String street;

  @JsonProperty("buildingNumber")
  private Integer buildingNumber;

  public BranchOfficeAddressDto city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  @NotNull 
  @Schema(name = "city", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public BranchOfficeAddressDto street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Get street
   * @return street
  */
  @NotNull 
  @Schema(name = "street", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public BranchOfficeAddressDto buildingNumber(Integer buildingNumber) {
    this.buildingNumber = buildingNumber;
    return this;
  }

  /**
   * Get buildingNumber
   * @return buildingNumber
  */
  @NotNull 
  @Schema(name = "buildingNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getBuildingNumber() {
    return buildingNumber;
  }

  public void setBuildingNumber(Integer buildingNumber) {
    this.buildingNumber = buildingNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BranchOfficeAddressDto branchOfficeAddress = (BranchOfficeAddressDto) o;
    return Objects.equals(this.city, branchOfficeAddress.city) &&
        Objects.equals(this.street, branchOfficeAddress.street) &&
        Objects.equals(this.buildingNumber, branchOfficeAddress.buildingNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, street, buildingNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BranchOfficeAddressDto {\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    buildingNumber: ").append(toIndentedString(buildingNumber)).append("\n");
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

