package by.sportliner.lk.core.model;

import jakarta.persistence.*;

/**
 * Task.
 */
@Entity
@Table(name = "task")
public class Task extends AbstractDataObject {

    /**
     * Assignee.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "assignee_id")
    private UserAccount assignee;

    /**
     *  Reporter.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "reporter_id")
    private UserAccount reporter;

    /**
     * Name.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Description.
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Status.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus status;

    public UserAccount getAssignee() {
        return assignee;
    }

    public void setAssignee(UserAccount assignee) {
        this.assignee = assignee;
    }

    public UserAccount getReporter() {
        return reporter;
    }

    public void setReporter(UserAccount reporter) {
        this.reporter = reporter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public enum TaskStatus {

        OPEN,

        IN_PROGRESS,

        CLOSED

    }

}
