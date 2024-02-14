CREATE TABLE application_settings
(
    id    TEXT NOT NULL,
    value TEXT NOT NULL,
    CONSTRAINT pk_application_settings PRIMARY KEY (id)
);

INSERT INTO application_settings(id, value)
VALUES ('epos.lastIndexInvoiceNumber.Michalenia', '1200'),
('epos.lastIndexInvoiceNumber.Sportliner', '1200');
