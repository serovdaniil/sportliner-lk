CREATE TABLE telegram_chat (
    id               UUID NOT NULL,
    chat_id          int  NOT NULL,
    username         TEXT NOT NULL,
    branch_office_id UUID NULL,
    child_fio        TEXT NULL,
    phone            TEXT NULL,
    diagnosis        TEXT NULL,
    date             DATE NULL,
    CONSTRAINT pk_telegram_chat PRIMARY KEY (id)
);

ALTER TABLE telegram_chat
    ADD CONSTRAINT fk_telegram_chat_branch_office FOREIGN KEY (branch_office_id) REFERENCES branch_office (id) ON DELETE CASCADE;
