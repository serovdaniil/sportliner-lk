package by.sportliner.lk.core.model;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Class schedule.
 */
@Embeddable
public class ClassSchedule {

    /**
     * Day.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    private DayOfWeek day;

    /**
     * Time.
     */
    @Column(name = "time")
    private LocalTime time;

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
