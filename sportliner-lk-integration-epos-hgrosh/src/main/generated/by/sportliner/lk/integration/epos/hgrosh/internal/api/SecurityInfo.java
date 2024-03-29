/*
 * EPOS public API
 * **Public API сервиса E-POS**  For mode details refer to: * [ Website ](https://www.e-pos.by) * [API Docs](https://api-epos.hgrosh.by/public/swagger/index.html)
 *
 * The version of the OpenAPI document: v1
 * Contact: support-api@epos.by
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package by.sportliner.lk.integration.epos.hgrosh.internal.api;

import java.util.Objects;
import java.util.Arrays;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.IdentityType;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.OAUTHSettings;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Информация по подключению к серверу авторизации
 */
@JsonPropertyOrder({
  SecurityInfo.JSON_PROPERTY_TYPE,
  SecurityInfo.JSON_PROPERTY_SETTINGS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SecurityInfo {
  public static final String JSON_PROPERTY_TYPE = "type";
  private IdentityType type;

  public static final String JSON_PROPERTY_SETTINGS = "settings";
  private OAUTHSettings settings;

  public SecurityInfo() {
  }

  public SecurityInfo type(IdentityType type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IdentityType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(IdentityType type) {
    this.type = type;
  }


  public SecurityInfo settings(OAUTHSettings settings) {
    
    this.settings = settings;
    return this;
  }

   /**
   * Get settings
   * @return settings
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OAUTHSettings getSettings() {
    return settings;
  }


  @JsonProperty(JSON_PROPERTY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSettings(OAUTHSettings settings) {
    this.settings = settings;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecurityInfo securityInfo = (SecurityInfo) o;
    return Objects.equals(this.type, securityInfo.type) &&
        Objects.equals(this.settings, securityInfo.settings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, settings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecurityInfo {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
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

