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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Структура для нотификаций
 */
@JsonPropertyOrder({
  NotifyParams.JSON_PROPERTY_EMAILS,
  NotifyParams.JSON_PROPERTY_SMSES,
  NotifyParams.JSON_PROPERTY_URLS,
  NotifyParams.JSON_PROPERTY_USERS,
  NotifyParams.JSON_PROPERTY_ONE_SIGNAL_USERS,
  NotifyParams.JSON_PROPERTY_CASH_BOX_NOTIFY_URL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class NotifyParams {
  public static final String JSON_PROPERTY_EMAILS = "emails";
  private JsonNullable<List<String>> emails = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_SMSES = "smses";
  private JsonNullable<List<String>> smses = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_URLS = "urls";
  private JsonNullable<List<String>> urls = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_USERS = "users";
  private JsonNullable<List<String>> users = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_ONE_SIGNAL_USERS = "oneSignalUsers";
  private JsonNullable<List<UUID>> oneSignalUsers = JsonNullable.<List<UUID>>undefined();

  public static final String JSON_PROPERTY_CASH_BOX_NOTIFY_URL = "cashBoxNotifyUrl";
  private JsonNullable<String> cashBoxNotifyUrl = JsonNullable.<String>undefined();

  public NotifyParams() {
  }

  public NotifyParams emails(List<String> emails) {
    this.emails = JsonNullable.<List<String>>of(emails);
    
    return this;
  }

  public NotifyParams addEmailsItem(String emailsItem) {
    if (this.emails == null || !this.emails.isPresent()) {
      this.emails = JsonNullable.<List<String>>of(new ArrayList<>());
    }
    try {
      this.emails.get().add(emailsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Список электронных адресов нотификации
   * @return emails
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public List<String> getEmails() {
        return emails.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EMAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getEmails_JsonNullable() {
    return emails;
  }
  
  @JsonProperty(JSON_PROPERTY_EMAILS)
  public void setEmails_JsonNullable(JsonNullable<List<String>> emails) {
    this.emails = emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = JsonNullable.<List<String>>of(emails);
  }


  public NotifyParams smses(List<String> smses) {
    this.smses = JsonNullable.<List<String>>of(smses);
    
    return this;
  }

  public NotifyParams addSmsesItem(String smsesItem) {
    if (this.smses == null || !this.smses.isPresent()) {
      this.smses = JsonNullable.<List<String>>of(new ArrayList<>());
    }
    try {
      this.smses.get().add(smsesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Список телефонов для смс-нотификации
   * @return smses
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public List<String> getSmses() {
        return smses.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getSmses_JsonNullable() {
    return smses;
  }
  
  @JsonProperty(JSON_PROPERTY_SMSES)
  public void setSmses_JsonNullable(JsonNullable<List<String>> smses) {
    this.smses = smses;
  }

  public void setSmses(List<String> smses) {
    this.smses = JsonNullable.<List<String>>of(smses);
  }


  public NotifyParams urls(List<String> urls) {
    this.urls = JsonNullable.<List<String>>of(urls);
    
    return this;
  }

  public NotifyParams addUrlsItem(String urlsItem) {
    if (this.urls == null || !this.urls.isPresent()) {
      this.urls = JsonNullable.<List<String>>of(new ArrayList<>());
    }
    try {
      this.urls.get().add(urlsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Список url для нотификации
   * @return urls
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public List<String> getUrls() {
        return urls.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_URLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getUrls_JsonNullable() {
    return urls;
  }
  
  @JsonProperty(JSON_PROPERTY_URLS)
  public void setUrls_JsonNullable(JsonNullable<List<String>> urls) {
    this.urls = urls;
  }

  public void setUrls(List<String> urls) {
    this.urls = JsonNullable.<List<String>>of(urls);
  }


  public NotifyParams users(List<String> users) {
    this.users = JsonNullable.<List<String>>of(users);
    
    return this;
  }

  public NotifyParams addUsersItem(String usersItem) {
    if (this.users == null || !this.users.isPresent()) {
      this.users = JsonNullable.<List<String>>of(new ArrayList<>());
    }
    try {
      this.users.get().add(usersItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Список пользователей для нотификации с помощью мессенджеров
   * @return users
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public List<String> getUsers() {
        return users.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_USERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getUsers_JsonNullable() {
    return users;
  }
  
  @JsonProperty(JSON_PROPERTY_USERS)
  public void setUsers_JsonNullable(JsonNullable<List<String>> users) {
    this.users = users;
  }

  public void setUsers(List<String> users) {
    this.users = JsonNullable.<List<String>>of(users);
  }


  public NotifyParams oneSignalUsers(List<UUID> oneSignalUsers) {
    this.oneSignalUsers = JsonNullable.<List<UUID>>of(oneSignalUsers);
    
    return this;
  }

  public NotifyParams addOneSignalUsersItem(UUID oneSignalUsersItem) {
    if (this.oneSignalUsers == null || !this.oneSignalUsers.isPresent()) {
      this.oneSignalUsers = JsonNullable.<List<UUID>>of(new ArrayList<>());
    }
    try {
      this.oneSignalUsers.get().add(oneSignalUsersItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Список пользователей onesignal, которых надо нотифицировать в приложение
   * @return oneSignalUsers
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonIgnore

  public List<UUID> getOneSignalUsers() {
        return oneSignalUsers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ONE_SIGNAL_USERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<UUID>> getOneSignalUsers_JsonNullable() {
    return oneSignalUsers;
  }
  
  @JsonProperty(JSON_PROPERTY_ONE_SIGNAL_USERS)
  public void setOneSignalUsers_JsonNullable(JsonNullable<List<UUID>> oneSignalUsers) {
    this.oneSignalUsers = oneSignalUsers;
  }

  public void setOneSignalUsers(List<UUID> oneSignalUsers) {
    this.oneSignalUsers = JsonNullable.<List<UUID>>of(oneSignalUsers);
  }


  public NotifyParams cashBoxNotifyUrl(String cashBoxNotifyUrl) {
    this.cashBoxNotifyUrl = JsonNullable.<String>of(cashBoxNotifyUrl);
    
    return this;
  }

   /**
   * Адрес для нотификации кассы
   * @return cashBoxNotifyUrl
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getCashBoxNotifyUrl() {
        return cashBoxNotifyUrl.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CASH_BOX_NOTIFY_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getCashBoxNotifyUrl_JsonNullable() {
    return cashBoxNotifyUrl;
  }
  
  @JsonProperty(JSON_PROPERTY_CASH_BOX_NOTIFY_URL)
  public void setCashBoxNotifyUrl_JsonNullable(JsonNullable<String> cashBoxNotifyUrl) {
    this.cashBoxNotifyUrl = cashBoxNotifyUrl;
  }

  public void setCashBoxNotifyUrl(String cashBoxNotifyUrl) {
    this.cashBoxNotifyUrl = JsonNullable.<String>of(cashBoxNotifyUrl);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotifyParams notifyParams = (NotifyParams) o;
    return equalsNullable(this.emails, notifyParams.emails) &&
        equalsNullable(this.smses, notifyParams.smses) &&
        equalsNullable(this.urls, notifyParams.urls) &&
        equalsNullable(this.users, notifyParams.users) &&
        equalsNullable(this.oneSignalUsers, notifyParams.oneSignalUsers) &&
        equalsNullable(this.cashBoxNotifyUrl, notifyParams.cashBoxNotifyUrl);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(emails), hashCodeNullable(smses), hashCodeNullable(urls), hashCodeNullable(users), hashCodeNullable(oneSignalUsers), hashCodeNullable(cashBoxNotifyUrl));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotifyParams {\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
    sb.append("    smses: ").append(toIndentedString(smses)).append("\n");
    sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    oneSignalUsers: ").append(toIndentedString(oneSignalUsers)).append("\n");
    sb.append("    cashBoxNotifyUrl: ").append(toIndentedString(cashBoxNotifyUrl)).append("\n");
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

