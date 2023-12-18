package by.sportliner.lk.core.model;

import jakarta.persistence.*;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User account.
 */
@Entity
@Table(name = "user_account")
public class UserAccount extends AbstractDataObject {

    /**
     * Username (login).
     *
     * <p>Must be unique, should be treated as case-insensitive.</p>
     */
    @Column(name = "username", nullable = false, unique = true, updatable = false)
    private String username;

    /**
     * User password, securely encoded.
     *
     * @see org.springframework.security.crypto.password.PasswordEncoder
     * @see PasswordEncoderFactories#createDelegatingPasswordEncoder()
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Whether password should be changed for some reason.
     */
    @Column(name = "password_must_be_changed", nullable = false)
    private boolean passwordMustBeChanged;

    /**
     * Timestamp of current password.
     */
    @Column(name = "password_timestamp", nullable = false)
    private Instant passwordTimestamp;

    /**
     * User role in the system.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    /**
     * User email address.
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Phone.
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * First name.
     */
    @Column(name = "person_first_name", nullable = false)
    private String firstName;

    /**
     * Last name.
     */
    @Column(name = "person_last_name", nullable = false)
    private String lastName;

    /**
     * Patronymic.
     */
    @Column(name = "person_patronymic", nullable = false)
    private String patronymic;

    /**
     * Pay Attention.
     */
    @Column(name = "pay_attention", nullable = false)
    private boolean payAttention;

    /**
     * Reason.
     */
    @Column(name = "reason")
    private String reason;

    /**
     * Account creation timestamp.
     */
    @Column(name = "create_timestamp", nullable = false)
    private Instant createTimestamp;

    /**
     * Last update timestamp.
     */
    @Column(name = "update_timestamp")
    private Instant updateTimestamp;

    /**
     * Last login timestamp.
     */
    @Column(name = "login_timestamp")
    private Instant loginTimestamp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordMustBeChanged() {
        return passwordMustBeChanged;
    }

    public void setPasswordMustBeChanged(boolean passwordMustBeChanged) {
        this.passwordMustBeChanged = passwordMustBeChanged;
    }

    public Instant getPasswordTimestamp() {
        return passwordTimestamp;
    }

    public void setPasswordTimestamp(Instant passwordTimestamp) {
        this.passwordTimestamp = passwordTimestamp;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public boolean isPayAttention() {
        return payAttention;
    }

    public void setPayAttention(boolean payAttention) {
        this.payAttention = payAttention;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Instant getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Instant createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Instant getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(Instant loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    public boolean isPasswordMatches(String rawPassword) {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder().matches(rawPassword, password);
    }

    public boolean hasAuthority(UserAuthority authority) {
        return getRole().getAuthorities().contains(authority);
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
