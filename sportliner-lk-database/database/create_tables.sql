-------------------------------------------------------------------------------
-- Database tables definitions.
--
-- Constrains and indexes are defined in separate files:
-- * create_constraints.sql
-- * create_indexes.sql
--
-- This helps to:
-- * remove ordering dependencies between inserts (while importing init/test data)
-- * speed up data importing process
-------------------------------------------------------------------------------


-------------------------------------------------------------------------------
-- Tables.
-------------------------------------------------------------------------------

/*
 * User account.
 *
 * id - unique identifier (PK)
 * username - user name/login (unique, case-insensitive)
 * password - user password, securely encoded
 * password_timestamp - timestamp of current password
 * password_must_be_changed - whether password must be changed for some reason
 * role - user role (enum, see cc_user_account_role)
 * email - user email address
 * phone - phone
 * person_first_name - person first name
 * person_last_name - person last name
 * person_patronymic - person patronymic
 * create_timestamp - account creation timestamp
 * update_timestamp - last account update timestamp
 * login_timestamp - last account login timestamp
 */
create TABLE user_account (
    id                       UUID        NOT NULL,
    username                 TEXT        NOT NULL,
    password                 TEXT        NOT NULL,
    password_timestamp       TIMESTAMPTZ NOT NULL,
    role                     TEXT        NOT NULL,
    email                    TEXT        NOT NULL,
    phone                    TEXT        NOT NULL,
    person_first_name        TEXT        NOT NULL,
    person_last_name         TEXT        NOT NULL,
    person_patronymic        TEXT        NOT NULL,
    create_timestamp         TIMESTAMPTZ NOT NULL,
    update_timestamp         TIMESTAMPTZ NULL,
    login_timestamp          TIMESTAMPTZ NULL,
    CONSTRAINT pk_user_account PRIMARY KEY (id)
);
