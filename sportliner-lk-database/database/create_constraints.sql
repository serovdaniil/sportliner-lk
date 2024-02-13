-- Database constraints definitions.

ALTER TABLE class_schedule
    ADD CONSTRAINT fk_class_schedule_branch_office FOREIGN KEY (branch_office_id) REFERENCES branch_office (id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_branch_office_user_account FOREIGN KEY (trainer_id) REFERENCES user_account (id) ON DELETE CASCADE;

ALTER TABLE attendance
    ADD CONSTRAINT fk_attendance_children FOREIGN KEY (child_id) REFERENCES children (id) ON DELETE CASCADE;

ALTER TABLE telegram_chat
    ADD CONSTRAINT fk_telegram_chat_branch_office FOREIGN KEY (branch_office_id) REFERENCES branch_office (id) ON DELETE CASCADE;

ALTER TABLE transaction
    ADD CONSTRAINT fk_transaction_children FOREIGN KEY (child_id) REFERENCES children (id) ON DELETE CASCADE;

ALTER TABLE trial_attendance
    ADD CONSTRAINT fk_trial_attendance_branch_office FOREIGN KEY (branch_office_id) REFERENCES branch_office (id) ON DELETE CASCADE;
