-- Database constraints definitions.

ALTER TABLE class_schedule
    ADD CONSTRAINT fk_class_schedule_branch_office FOREIGN KEY (branch_office_id) REFERENCES branch_office (id) ON DELETE CASCADE;

ALTER TABLE branch_office
    ADD CONSTRAINT fk_branch_office_user_account FOREIGN KEY (trainer_id) REFERENCES user_account (id) ON DELETE CASCADE;

