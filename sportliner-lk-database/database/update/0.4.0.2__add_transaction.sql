ALTER TABLE children
    ADD COLUMN invoice_number TEXT    NULL,
    ADD COLUMN benefits       BOOLEAN NULL,
    ADD COLUMN tariff         TEXT    NULL,
    DROP COLUMN number_classes_per_week;

UPDATE children
SET invoice_number = '', benefits = false, tariff = 'TWO_LESSONS_PER_WEEK';

ALTER TABLE children
    ALTER COLUMN invoice_number SET NOT NULL,
    ALTER COLUMN benefits SET NOT NULL,
    ALTER COLUMN tariff SET NOT NULL;

ALTER TABLE children
    RENAME number_classes_per_month to number_classes_per_week;

CREATE TABLE transaction (
    id                UUID    NOT NULL,
    child_id          UUID    NOT NULL,
    date              DATE    NOT NULL,
    invoice_amount    NUMERIC NOT NULL,
    number_of_lessons NUMERIC NOT NULL,
    status            TEXT    NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id)
);

ALTER TABLE transaction
    ADD CONSTRAINT fk_transaction_children FOREIGN KEY (child_id) REFERENCES children (id) ON DELETE CASCADE;
