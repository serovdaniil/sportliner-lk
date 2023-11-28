package by.sportliner.lk.core.model;

/**
 * User authorities (permissions).
 */
public enum UserAuthority {

    /**
     * Authenticated.
     */
    AUTHENTICATED,

    /**
     * Allows to access application.
     */
    ACCESS_APPLICATION,

    /**
     * Allows parent functions.
     */
    PARENT,

    /**
     * Allows trainer functions.
     */
    TRAINER,

    /**
     * Allows administrative functions.
     */
    ADMINISTRATIVE

}
