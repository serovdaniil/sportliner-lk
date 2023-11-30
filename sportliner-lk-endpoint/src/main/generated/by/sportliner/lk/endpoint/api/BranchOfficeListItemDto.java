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
 * Branch office list item
 */

@Schema(name = "BranchOfficeListItem", description = "Branch office list item")
@JsonTypeName("BranchOfficeListItem")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class BranchOfficeListItemDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("address")
  private String address;

  @JsonProperty("trainer")
  private String trainer;

  public BranchOfficeListItemDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.REQUIRED)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BranchOfficeListItemDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BranchOfficeListItemDto address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @NotNull 
  @Schema(name = "address", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public BranchOfficeListItemDto trainer(String trainer) {
    this.trainer = trainer;
    return this;
  }

  /**
   * Get trainer
   * @return trainer
  */
  @NotNull 
  @Schema(name = "trainer", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getTrainer() {
    return trainer;
  }

  public void setTrainer(String trainer) {
    this.trainer = trainer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BranchOfficeListItemDto branchOfficeListItem = (BranchOfficeListItemDto) o;
    return Objects.equals(this.id, branchOfficeListItem.id) &&
        Objects.equals(this.name, branchOfficeListItem.name) &&
        Objects.equals(this.address, branchOfficeListItem.address) &&
        Objects.equals(this.trainer, branchOfficeListItem.trainer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, trainer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BranchOfficeListItemDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    trainer: ").append(toIndentedString(trainer)).append("\n");
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

