ALTER TABLE telegram_chat
    DROP COLUMN child_fio,
    DROP COLUMN diagnosis,
    DROP COLUMN date,
    ADD COLUMN create_timestamp TIMESTAMPTZ NOT NULL;

