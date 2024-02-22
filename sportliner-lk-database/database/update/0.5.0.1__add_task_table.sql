CREATE TABLE task (
    id          TEXT NOT NULL,
    assignee_id TEXT NOT NULL,
    reporter_id TEXT NOT NULL,
    name        TEXT NOT NULL,
    description TEXT NOT NULL,
    status      TEXT NOT NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

ALTER TABLE task
    ADD CONSTRAINT fk_task_assignee FOREIGN KEY (assignee_id) REFERENCES user_account (id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_task_reporter FOREIGN KEY (reporter_id) REFERENCES user_account (id) ON DELETE CASCADE;
