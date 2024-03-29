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
import by.sportliner.lk.integration.epos.hgrosh.internal.api.BusinessCard;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.Contact;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.Currency;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.LegalInfo;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.MerchantInfo;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.NotifyParams;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.Origin;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.RetailOutlet;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.Service;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ServiceProviderContract;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ServiceProviderIII;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ServiceProviderReport;
import by.sportliner.lk.integration.epos.hgrosh.internal.api.ServiceProviderStateEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * Производитель услуг.
 */
@JsonPropertyOrder({
  ServiceProvider.JSON_PROPERTY_CODE,
  ServiceProvider.JSON_PROPERTY_LEGAL_INFO,
  ServiceProvider.JSON_PROPERTY_BUSINESS_CARD,
  ServiceProvider.JSON_PROPERTY_MERCHANT,
  ServiceProvider.JSON_PROPERTY_CONTRACT,
  ServiceProvider.JSON_PROPERTY_SERVICES,
  ServiceProvider.JSON_PROPERTY_CONTACTS,
  ServiceProvider.JSON_PROPERTY_CURRENCIES,
  ServiceProvider.JSON_PROPERTY_RETAIL_OUTLETS,
  ServiceProvider.JSON_PROPERTY_STATE,
  ServiceProvider.JSON_PROPERTY_ERIP_STATE,
  ServiceProvider.JSON_PROPERTY_REPORTS,
  ServiceProvider.JSON_PROPERTY_LOYALITY_CODE,
  ServiceProvider.JSON_PROPERTY_NOTIFY_PARAMS,
  ServiceProvider.JSON_PROPERTY_CAN_BIOMETRY_PAY,
  ServiceProvider.JSON_PROPERTY_III_INFO,
  ServiceProvider.JSON_PROPERTY_ORIGIN
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ServiceProvider {
  public static final String JSON_PROPERTY_CODE = "code";
  private Long code;

  public static final String JSON_PROPERTY_LEGAL_INFO = "legalInfo";
  private LegalInfo legalInfo;

  public static final String JSON_PROPERTY_BUSINESS_CARD = "businessCard";
  private BusinessCard businessCard;

  public static final String JSON_PROPERTY_MERCHANT = "merchant";
  private MerchantInfo merchant;

  public static final String JSON_PROPERTY_CONTRACT = "contract";
  private ServiceProviderContract contract;

  public static final String JSON_PROPERTY_SERVICES = "services";
  private JsonNullable<List<Service>> services = JsonNullable.<List<Service>>undefined();

  public static final String JSON_PROPERTY_CONTACTS = "contacts";
  private JsonNullable<List<Contact>> contacts = JsonNullable.<List<Contact>>undefined();

  public static final String JSON_PROPERTY_CURRENCIES = "currencies";
  private JsonNullable<List<Currency>> currencies = JsonNullable.<List<Currency>>undefined();

  public static final String JSON_PROPERTY_RETAIL_OUTLETS = "retailOutlets";
  private JsonNullable<List<RetailOutlet>> retailOutlets = JsonNullable.<List<RetailOutlet>>undefined();

  public static final String JSON_PROPERTY_STATE = "state";
  private ServiceProviderStateEnum state;

  public static final String JSON_PROPERTY_ERIP_STATE = "eripState";
  private ServiceProviderStateEnum eripState;

  public static final String JSON_PROPERTY_REPORTS = "reports";
  private JsonNullable<List<ServiceProviderReport>> reports = JsonNullable.<List<ServiceProviderReport>>undefined();

  public static final String JSON_PROPERTY_LOYALITY_CODE = "loyalityCode";
  private JsonNullable<String> loyalityCode = JsonNullable.<String>undefined();

  public static final String JSON_PROPERTY_NOTIFY_PARAMS = "notifyParams";
  private NotifyParams notifyParams;

  public static final String JSON_PROPERTY_CAN_BIOMETRY_PAY = "canBiometryPay";
  private Boolean canBiometryPay;

  public static final String JSON_PROPERTY_III_INFO = "iiiInfo";
  private ServiceProviderIII iiiInfo;

  public static final String JSON_PROPERTY_ORIGIN = "origin";
  private Origin origin;

  public ServiceProvider() {
  }

  public ServiceProvider code(Long code) {
    
    this.code = code;
    return this;
  }

   /**
   * Уникальный код ПУ.
   * @return code
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getCode() {
    return code;
  }


  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCode(Long code) {
    this.code = code;
  }


  public ServiceProvider legalInfo(LegalInfo legalInfo) {
    
    this.legalInfo = legalInfo;
    return this;
  }

   /**
   * Get legalInfo
   * @return legalInfo
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_LEGAL_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LegalInfo getLegalInfo() {
    return legalInfo;
  }


  @JsonProperty(JSON_PROPERTY_LEGAL_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLegalInfo(LegalInfo legalInfo) {
    this.legalInfo = legalInfo;
  }


  public ServiceProvider businessCard(BusinessCard businessCard) {
    
    this.businessCard = businessCard;
    return this;
  }

   /**
   * Get businessCard
   * @return businessCard
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_BUSINESS_CARD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BusinessCard getBusinessCard() {
    return businessCard;
  }


  @JsonProperty(JSON_PROPERTY_BUSINESS_CARD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBusinessCard(BusinessCard businessCard) {
    this.businessCard = businessCard;
  }


  public ServiceProvider merchant(MerchantInfo merchant) {
    
    this.merchant = merchant;
    return this;
  }

   /**
   * Get merchant
   * @return merchant
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_MERCHANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MerchantInfo getMerchant() {
    return merchant;
  }


  @JsonProperty(JSON_PROPERTY_MERCHANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchant(MerchantInfo merchant) {
    this.merchant = merchant;
  }


  public ServiceProvider contract(ServiceProviderContract contract) {
    
    this.contract = contract;
    return this;
  }

   /**
   * Get contract
   * @return contract
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_CONTRACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ServiceProviderContract getContract() {
    return contract;
  }


  @JsonProperty(JSON_PROPERTY_CONTRACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContract(ServiceProviderContract contract) {
    this.contract = contract;
  }


  public ServiceProvider services(List<Service> services) {
    this.services = JsonNullable.<List<Service>>of(services);
    
    return this;
  }

  public ServiceProvider addServicesItem(Service servicesItem) {
    if (this.services == null || !this.services.isPresent()) {
      this.services = JsonNullable.<List<Service>>of(new ArrayList<>());
    }
    try {
      this.services.get().add(servicesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Сервисы ПУ.
   * @return services
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonIgnore

  public List<Service> getServices() {
        return services.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<Service>> getServices_JsonNullable() {
    return services;
  }
  
  @JsonProperty(JSON_PROPERTY_SERVICES)
  public void setServices_JsonNullable(JsonNullable<List<Service>> services) {
    this.services = services;
  }

  public void setServices(List<Service> services) {
    this.services = JsonNullable.<List<Service>>of(services);
  }


  public ServiceProvider contacts(List<Contact> contacts) {
    this.contacts = JsonNullable.<List<Contact>>of(contacts);
    
    return this;
  }

  public ServiceProvider addContactsItem(Contact contactsItem) {
    if (this.contacts == null || !this.contacts.isPresent()) {
      this.contacts = JsonNullable.<List<Contact>>of(new ArrayList<>());
    }
    try {
      this.contacts.get().add(contactsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Контакты ПУ
   * @return contacts
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonIgnore

  public List<Contact> getContacts() {
        return contacts.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<Contact>> getContacts_JsonNullable() {
    return contacts;
  }
  
  @JsonProperty(JSON_PROPERTY_CONTACTS)
  public void setContacts_JsonNullable(JsonNullable<List<Contact>> contacts) {
    this.contacts = contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = JsonNullable.<List<Contact>>of(contacts);
  }


  public ServiceProvider currencies(List<Currency> currencies) {
    this.currencies = JsonNullable.<List<Currency>>of(currencies);
    
    return this;
  }

  public ServiceProvider addCurrenciesItem(Currency currenciesItem) {
    if (this.currencies == null || !this.currencies.isPresent()) {
      this.currencies = JsonNullable.<List<Currency>>of(new ArrayList<>());
    }
    try {
      this.currencies.get().add(currenciesItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Список доступных валют ПУ.
   * @return currencies
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonIgnore

  public List<Currency> getCurrencies() {
        return currencies.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CURRENCIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<Currency>> getCurrencies_JsonNullable() {
    return currencies;
  }
  
  @JsonProperty(JSON_PROPERTY_CURRENCIES)
  public void setCurrencies_JsonNullable(JsonNullable<List<Currency>> currencies) {
    this.currencies = currencies;
  }

  public void setCurrencies(List<Currency> currencies) {
    this.currencies = JsonNullable.<List<Currency>>of(currencies);
  }


  public ServiceProvider retailOutlets(List<RetailOutlet> retailOutlets) {
    this.retailOutlets = JsonNullable.<List<RetailOutlet>>of(retailOutlets);
    
    return this;
  }

  public ServiceProvider addRetailOutletsItem(RetailOutlet retailOutletsItem) {
    if (this.retailOutlets == null || !this.retailOutlets.isPresent()) {
      this.retailOutlets = JsonNullable.<List<RetailOutlet>>of(new ArrayList<>());
    }
    try {
      this.retailOutlets.get().add(retailOutletsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * РТТ ПУ.
   * @return retailOutlets
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonIgnore

  public List<RetailOutlet> getRetailOutlets() {
        return retailOutlets.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RETAIL_OUTLETS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<RetailOutlet>> getRetailOutlets_JsonNullable() {
    return retailOutlets;
  }
  
  @JsonProperty(JSON_PROPERTY_RETAIL_OUTLETS)
  public void setRetailOutlets_JsonNullable(JsonNullable<List<RetailOutlet>> retailOutlets) {
    this.retailOutlets = retailOutlets;
  }

  public void setRetailOutlets(List<RetailOutlet> retailOutlets) {
    this.retailOutlets = JsonNullable.<List<RetailOutlet>>of(retailOutlets);
  }


  public ServiceProvider state(ServiceProviderStateEnum state) {
    
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ServiceProviderStateEnum getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(ServiceProviderStateEnum state) {
    this.state = state;
  }


  public ServiceProvider eripState(ServiceProviderStateEnum eripState) {
    
    this.eripState = eripState;
    return this;
  }

   /**
   * Get eripState
   * @return eripState
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_ERIP_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ServiceProviderStateEnum getEripState() {
    return eripState;
  }


  @JsonProperty(JSON_PROPERTY_ERIP_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEripState(ServiceProviderStateEnum eripState) {
    this.eripState = eripState;
  }


  public ServiceProvider reports(List<ServiceProviderReport> reports) {
    this.reports = JsonNullable.<List<ServiceProviderReport>>of(reports);
    
    return this;
  }

  public ServiceProvider addReportsItem(ServiceProviderReport reportsItem) {
    if (this.reports == null || !this.reports.isPresent()) {
      this.reports = JsonNullable.<List<ServiceProviderReport>>of(new ArrayList<>());
    }
    try {
      this.reports.get().add(reportsItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Отчеты ПУ
   * @return reports
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonIgnore

  public List<ServiceProviderReport> getReports() {
        return reports.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPORTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<ServiceProviderReport>> getReports_JsonNullable() {
    return reports;
  }
  
  @JsonProperty(JSON_PROPERTY_REPORTS)
  public void setReports_JsonNullable(JsonNullable<List<ServiceProviderReport>> reports) {
    this.reports = reports;
  }

  public void setReports(List<ServiceProviderReport> reports) {
    this.reports = JsonNullable.<List<ServiceProviderReport>>of(reports);
  }


  public ServiceProvider loyalityCode(String loyalityCode) {
    this.loyalityCode = JsonNullable.<String>of(loyalityCode);
    
    return this;
  }

   /**
   * Код ПУ в системе лояльности.
   * @return loyalityCode
  **/
  @jakarta.annotation.Nullable

  @JsonIgnore

  public String getLoyalityCode() {
        return loyalityCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOYALITY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getLoyalityCode_JsonNullable() {
    return loyalityCode;
  }
  
  @JsonProperty(JSON_PROPERTY_LOYALITY_CODE)
  public void setLoyalityCode_JsonNullable(JsonNullable<String> loyalityCode) {
    this.loyalityCode = loyalityCode;
  }

  public void setLoyalityCode(String loyalityCode) {
    this.loyalityCode = JsonNullable.<String>of(loyalityCode);
  }


  public ServiceProvider notifyParams(NotifyParams notifyParams) {
    
    this.notifyParams = notifyParams;
    return this;
  }

   /**
   * Get notifyParams
   * @return notifyParams
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_NOTIFY_PARAMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NotifyParams getNotifyParams() {
    return notifyParams;
  }


  @JsonProperty(JSON_PROPERTY_NOTIFY_PARAMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotifyParams(NotifyParams notifyParams) {
    this.notifyParams = notifyParams;
  }


  public ServiceProvider canBiometryPay(Boolean canBiometryPay) {
    
    this.canBiometryPay = canBiometryPay;
    return this;
  }

   /**
   * Признак возможности оплаты с помощью биометрии
   * @return canBiometryPay
  **/
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_CAN_BIOMETRY_PAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean isCanBiometryPay() {
    return canBiometryPay;
  }


  @JsonProperty(JSON_PROPERTY_CAN_BIOMETRY_PAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCanBiometryPay(Boolean canBiometryPay) {
    this.canBiometryPay = canBiometryPay;
  }


  public ServiceProvider iiiInfo(ServiceProviderIII iiiInfo) {
    
    this.iiiInfo = iiiInfo;
    return this;
  }

   /**
   * Get iiiInfo
   * @return iiiInfo
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_III_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ServiceProviderIII getIiiInfo() {
    return iiiInfo;
  }


  @JsonProperty(JSON_PROPERTY_III_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIiiInfo(ServiceProviderIII iiiInfo) {
    this.iiiInfo = iiiInfo;
  }


  public ServiceProvider origin(Origin origin) {
    
    this.origin = origin;
    return this;
  }

   /**
   * Get origin
   * @return origin
  **/
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_ORIGIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Origin getOrigin() {
    return origin;
  }


  @JsonProperty(JSON_PROPERTY_ORIGIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrigin(Origin origin) {
    this.origin = origin;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceProvider serviceProvider = (ServiceProvider) o;
    return Objects.equals(this.code, serviceProvider.code) &&
        Objects.equals(this.legalInfo, serviceProvider.legalInfo) &&
        Objects.equals(this.businessCard, serviceProvider.businessCard) &&
        Objects.equals(this.merchant, serviceProvider.merchant) &&
        Objects.equals(this.contract, serviceProvider.contract) &&
        equalsNullable(this.services, serviceProvider.services) &&
        equalsNullable(this.contacts, serviceProvider.contacts) &&
        equalsNullable(this.currencies, serviceProvider.currencies) &&
        equalsNullable(this.retailOutlets, serviceProvider.retailOutlets) &&
        Objects.equals(this.state, serviceProvider.state) &&
        Objects.equals(this.eripState, serviceProvider.eripState) &&
        equalsNullable(this.reports, serviceProvider.reports) &&
        equalsNullable(this.loyalityCode, serviceProvider.loyalityCode) &&
        Objects.equals(this.notifyParams, serviceProvider.notifyParams) &&
        Objects.equals(this.canBiometryPay, serviceProvider.canBiometryPay) &&
        Objects.equals(this.iiiInfo, serviceProvider.iiiInfo) &&
        Objects.equals(this.origin, serviceProvider.origin);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, legalInfo, businessCard, merchant, contract, hashCodeNullable(services), hashCodeNullable(contacts), hashCodeNullable(currencies), hashCodeNullable(retailOutlets), state, eripState, hashCodeNullable(reports), hashCodeNullable(loyalityCode), notifyParams, canBiometryPay, iiiInfo, origin);
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
    sb.append("class ServiceProvider {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    legalInfo: ").append(toIndentedString(legalInfo)).append("\n");
    sb.append("    businessCard: ").append(toIndentedString(businessCard)).append("\n");
    sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
    sb.append("    contract: ").append(toIndentedString(contract)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    currencies: ").append(toIndentedString(currencies)).append("\n");
    sb.append("    retailOutlets: ").append(toIndentedString(retailOutlets)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    eripState: ").append(toIndentedString(eripState)).append("\n");
    sb.append("    reports: ").append(toIndentedString(reports)).append("\n");
    sb.append("    loyalityCode: ").append(toIndentedString(loyalityCode)).append("\n");
    sb.append("    notifyParams: ").append(toIndentedString(notifyParams)).append("\n");
    sb.append("    canBiometryPay: ").append(toIndentedString(canBiometryPay)).append("\n");
    sb.append("    iiiInfo: ").append(toIndentedString(iiiInfo)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
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

