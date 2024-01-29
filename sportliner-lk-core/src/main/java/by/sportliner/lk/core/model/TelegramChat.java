package by.sportliner.lk.core.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "telegram_chat")
public class TelegramChat extends AbstractDataObject {

    /**
     * Chat ID.
     */
    @Column(name = "chat_id", nullable = false)
    private Long chatId;

    /**
     * Username.
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * Child fio.
     */
    @Column(name = "child_fio")
    private String childFio;

    /**
     * Branch office.
     */
    @OneToOne(optional = true)
    @JoinColumn(name = "branch_office_id")
    private BranchOffice branchOffice;

    /**
     * Phone.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Diagnosis.
     */
    @Column(name = "diagnosis")
    private String diagnosis;

    /**
     * Date.
     */
    @Column(name = "date")
    private LocalDate date;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChildFio() {
        return childFio;
    }

    public void setChildFio(String childFio) {
        this.childFio = childFio;
    }

    public BranchOffice getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(BranchOffice branchOffice) {
        this.branchOffice = branchOffice;
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
}
