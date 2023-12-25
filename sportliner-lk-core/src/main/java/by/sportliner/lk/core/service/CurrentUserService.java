package by.sportliner.lk.core.service;


import by.sportliner.lk.core.model.UserAccount;

/**
 * Service, providing information about "current" user.
 */
public interface CurrentUserService {

    /**
     * Returns current user id.
     *
     * @return current user id
     */
    String getUserId();

    /**
     * Returns current user account.
     *
     * @return current user account
     */
    UserAccount getUserAccount();

    /**
     * Returns target user account.
     *
     * <p>Retrieves user id from request headers and returns related user account.</p>
     *
     * <p>If user id is null, then returns current user account.</p>
     *
     * @return target user account
     */
    UserAccount getTargetUserAccount();
}
