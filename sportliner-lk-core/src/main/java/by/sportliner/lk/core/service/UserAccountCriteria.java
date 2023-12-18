package by.sportliner.lk.core.service;


import by.sportliner.lk.core.model.UserAccount;
import by.sportliner.lk.core.model.UserRole;

/**
 * Criteria for filtering {@link UserAccount}s.
 */
public class UserAccountCriteria {

    private String lastName;

    private UserRole role;

    private Boolean payAttention;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Boolean getPayAttention() {
        return payAttention;
    }

    public void setPayAttention(Boolean payAttention) {
        this.payAttention = payAttention;
    }
}
