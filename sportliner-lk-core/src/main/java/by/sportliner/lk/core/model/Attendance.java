package by.sportliner.lk.core.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Attendance.
 */
@Entity
@Table(name = "attendance")
public class Attendance extends AbstractDataObject{

    /**
     * Child.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "child_id")
    private Child child;

    /**
     * Date.
     */
    @Column(name = "date")
    private LocalDate date;

    /**
     * Time.
     */
    @Column(name = "time")
    private LocalTime time;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Attendance{");
        sb.append("child=").append(child);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}
