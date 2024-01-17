CREATE TABLE trial_attendance (
    id               UUID NOT NULL,
    branch_office_id UUID NOT NULL,
    name             TEXT NOT NULL,
    phone            TEXT NOT NULL,
    diagnosis        TEXT NOT NULL,
    date             DATE NOT NULL,
    status           TEXT NOT NULL,
    CONSTRAINT pk_trial_attendance PRIMARY KEY (id)
)
