package by.sportliner.lk.core.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Attendance.
 */
@Entity
@Table(name = "trial_attendance")
public class TrialAttendance extends AbstractDataObject{

    /**
     * Branch office.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "branch_office_id", nullable = false)
    private BranchOffice branchOffice;

    /**
     * Name.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Phone.
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * Diagnosis.
     */
    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    /**
     * Date.
     */
    @Column(name = "date", nullable = false)
    private LocalDate date;

    /**
     * Status.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TrialAttendanceStatus trialAttendanceStatus;

    public BranchOffice getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(BranchOffice branchOffice) {
        this.branchOffice = branchOffice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TrialAttendanceStatus getTrialAttendanceStatus() {
        return trialAttendanceStatus;
    }

    public void setTrialAttendanceStatus(TrialAttendanceStatus trialAttendanceStatus) {
        this.trialAttendanceStatus = trialAttendanceStatus;
    }

    public enum TrialAttendanceStatus {

        ATTENDED,

        UNATTENDED

    }

}
