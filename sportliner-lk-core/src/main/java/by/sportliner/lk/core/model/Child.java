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
     * Number of classes per month.
     */
    @Column(name = "number_classes_per_month", nullable = false)
    private int numberClassesPerMonth;

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

    public int getNumberClassesPerMonth() {
        return numberClassesPerMonth;
    }

    public void setNumberClassesPerMonth(int numberClassesPerMonth) {
        this.numberClassesPerMonth = numberClassesPerMonth;
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
}
