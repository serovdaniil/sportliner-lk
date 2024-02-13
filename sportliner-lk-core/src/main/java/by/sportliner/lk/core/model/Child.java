package by.sportliner.lk.core.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Child.
 */
@Entity
@Table(name = "children")
public class Child extends AbstractDataObject {

    /**
     * A parent who pays for classes.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "parent_id")
    private UserAccount parent;

    /**
     * Branch office.
     */
    @OneToOne(optional = false)
    @JoinColumn(name = "branch_office_id")
    private BranchOffice branchOffice;

    /**
     * Last name.
     */
    @Column(name = "person_last_name", nullable = false)
    private String lastName;

    /**
     * First name.
     */
    @Column(name = "person_first_name", nullable = false)
    private String firstName;

    /**
     * Patronymic.
     */
    @Column(name = "person_patronymic", nullable = false)
    private String patronymic;

    /**
     * Birthday.
     */
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    /**
     * Diagnosis.
     */
    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    /**
     * Notes.
     */
    @Column(name = "notes")
    private String notes;

    /**
     * Tuition balance.
     */
    @Column(name = "tuition_balance", nullable = false)
    private int tuitionBalance;

    /**
     * Tariff.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tariff", nullable = false)
    private Tariff tariff;

    /**
     * Payment type.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    /**
     * Invoice number.
     */
    @Column(name = "invoice_number", nullable = false)
    private String invoiceNumber;

    /**
     * Benefits.
     */
    @Column(name = "benefits", nullable = false)
    private boolean benefits;

    /**
     * Paying entity.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "paying_entity", nullable = false)
    private PayingEntity payingEntity;

    public UserAccount getParent() {
        return parent;
    }

    public void setParent(UserAccount parent) {
        this.parent = parent;
    }

    public BranchOffice getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(BranchOffice branchOffice) {
        this.branchOffice = branchOffice;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getTuitionBalance() {
        return tuitionBalance;
    }

    public void setTuitionBalance(int tuitionBalance) {
        this.tuitionBalance = tuitionBalance;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public boolean isBenefits() {
        return benefits;
    }

    public void setBenefits(boolean benefits) {
        this.benefits = benefits;
    }

    public PayingEntity getPayingEntity() {
        return payingEntity;
    }

    public void setPayingEntity(PayingEntity payingEntity) {
        this.payingEntity = payingEntity;
    }

    public int getAmountClassesForPay() {
        if (paymentType.equals(PaymentType.PREPAYMENT)) {
            return (tariff.getLessonsPerWeek() * 4) - tuitionBalance;
        } else {
            return tuitionBalance * -1; // необходимо, для перевода в положительное количество занятий
        }
    }

    public void incrementTuitionBalance() {
        tuitionBalance++;
    }

    public void incrementTuitionBalance(int numberOfLessons) {
        tuitionBalance = tuitionBalance + numberOfLessons;
    }

    public String getFullName() {
        return Stream.<String>builder()
            .add(lastName)
            .add(firstName)
            .add(patronymic)
            .build()
            .filter(Objects::nonNull)
            .collect(Collectors.joining(" "));
    }

    public void minusClass() {
        minusFewClasses(1);
    }

    public void minusFewClasses(int count) {
        tuitionBalance = tuitionBalance - count;
    }

    public String getFullInvoiceNumber() {
        return "${serviceProviderId}-${serviceId}-${invoiceNumber}"
            .replace("${serviceProviderId}", payingEntity.getServiceProviderId())
            .replace("${serviceId}", payingEntity.getServiceId())
            .replace("${invoiceNumber}", invoiceNumber);
    }

}
