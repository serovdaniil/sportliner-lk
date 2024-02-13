ALTER TABLE children
    ADD COLUMN paying_entity TEXT NULL;

UPDATE children
SET paying_entity = 'MICHALENIA';

ALTER TABLE children
    ALTER COLUMN paying_entity SET NOT NULL;
