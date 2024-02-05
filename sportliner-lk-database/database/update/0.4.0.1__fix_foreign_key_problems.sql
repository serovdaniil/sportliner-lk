ALTER TABLE trial_attendance
    ADD CONSTRAINT fk_trial_attendance_branch_office FOREIGN KEY (branch_office_id) REFERENCES branch_office (id) ON DELETE CASCADE;
