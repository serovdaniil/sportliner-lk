package by.sportliner.lk.core.model;

public enum PayingEntity {

    MICHALENIA("epos.lastIndexInvoiceNumber.Michalenia", "1", "10609"),

    SPORTLINER("epos.lastIndexInvoiceNumber.Sportliner", "1", "10609"); // TODO изменить индекс сервиса оплаты и номер клиента

    PayingEntity(String id, String serviceId, String serviceProviderId) {
        this.id = id;
        this.serviceId = serviceId;
        this.serviceProviderId = serviceProviderId;
    }

    private String id;

    private String serviceId;

    private String serviceProviderId;

    public String getId() {
        return id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceProviderId() {
        return serviceProviderId;
    }
}
