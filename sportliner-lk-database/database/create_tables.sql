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
    password_must_be_changed BOOLEAN     NOT NULL,
    password_timestamp       TIMESTAMPTZ NOT NULL,
    role                     TEXT        NOT NULL,
    email                    TEXT        NOT NULL,
    phone                    TEXT        NOT NULL,
    person_first_name        TEXT        NOT NULL,
    person_last_name         TEXT        NOT NULL,
    person_patronymic        TEXT        NOT NULL,
    pay_attention            BOOLEAN     NOT NULL,
    reason                   TEXT        NULL,
    create_timestamp         TIMESTAMPTZ NOT NULL,
    update_timestamp         TIMESTAMPTZ NULL,
    login_timestamp          TIMESTAMPTZ NULL,
    CONSTRAINT pk_user_account PRIMARY KEY (id)
);

CREATE TABLE branch_office (
    id         UUID  NOT NULL,
    name       TEXT  NOT NULL,
    address    JSONB NOT NULL,
    CONSTRAINT pk_branch_office PRIMARY KEY (id)
);

CREATE TABLE class_schedule (
    branch_office_id UUID  NOT NULL,
    trainer_id       UUID  NOT NULL,
    day              TEXT  NOT NULL,
    time             time  NOT NULL,
    CONSTRAINT pk_class_schedule PRIMARY KEY (branch_office_id, day, time)
);

CREATE TABLE children (
    id                         UUID     NOT NULL,
    parent_id                  UUID     NOT NULL,
    branch_office_id           UUID     NOT NULL,
    person_last_name           TEXT     NOT NULL,
    person_first_name          TEXT     NOT NULL,
    person_patronymic          TEXT     NOT NULL,
    birthday                   DATE     NOT NULL,
    diagnosis                  TEXT     NOT NULL,
    tuition_balance            int      NOT NULL,
    number_classes_per_week    int      NOT NULL,
    payment_type               TEXT     NOT NULL,
    invoice_number             TEXT     NOT NULL,
    tariff                     TEXT     NOT NULL,
    benefits                   BOOLEAN  NOT NULL,
    paying_entity              TEXT     NOT NULL,
    notes                      TEXT     NULL,
    CONSTRAINT pk_children PRIMARY KEY (id)
);

CREATE TABLE attendance (
    id       UUID NOT NULL,
    child_id UUID NOT NULL,
    date     DATE NOT NULL,
    time     TIME NOT NULL,
    CONSTRAINT pk_attendance PRIMARY KEY (id)
);

CREATE TABLE trial_attendance (
    id                 UUID NOT NULL,
    branch_office_id   UUID NOT NULL,
    name               TEXT NOT NULL,
    phone              TEXT NOT NULL,
    diagnosis          TEXT NOT NULL,
    date               DATE NOT NULL,
    status             TEXT NOT NULL,
    telegram_username  TEXT NULL,
    CONSTRAINT pk_trial_attendance PRIMARY KEY (id)
);

CREATE TABLE telegram_chat (
    id               UUID        NOT NULL,
    chat_id          int         NOT NULL,
    username         TEXT        NOT NULL,
    branch_office_id UUID        NOT NULL,
    phone            TEXT        NOT NULL,
    create_timestamp TIMESTAMPTZ NOT NULL,
    CONSTRAINT pk_telegram_chat PRIMARY KEY (id)
);

CREATE TABLE transaction (
    id                 UUID    NOT NULL,
    child_id           UUID    NOT NULL,
    date               DATE    NOT NULL,
    invoice_amount     NUMERIC NOT NULL,
    number_of_lessons  NUMERIC NOT NULL,
    status             TEXT    NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id)
);

CREATE TABLE application_settings
(
    id    TEXT NOT NULL,
    value TEXT NOT NULL,
    CONSTRAINT pk_application_settings PRIMARY KEY (id)
);

CREATE TABLE task (
    id          UUID NOT NULL,
    assignee_id UUID NOT NULL,
    reporter_id UUID NOT NULL,
    name        TEXT NOT NULL,
    description TEXT NOT NULL,
    status      TEXT NOT NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);
