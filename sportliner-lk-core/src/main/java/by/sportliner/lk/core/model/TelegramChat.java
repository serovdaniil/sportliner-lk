package by.sportliner.lk.core.model;

import jakarta.persistence.*;

import java.time.Instant;

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
    @Column(name = "username")
    private String username;

    /**
     * Branch office.
     */
    @OneToOne
    @JoinColumn(name = "branch_office_id")
    private BranchOffice branchOffice;

    /**
     * Phone.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Сreation timestamp.
     */
    @Column(name = "create_timestamp", nullable = false)
    private Instant createTimestamp;

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

    public Instant getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Instant createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
