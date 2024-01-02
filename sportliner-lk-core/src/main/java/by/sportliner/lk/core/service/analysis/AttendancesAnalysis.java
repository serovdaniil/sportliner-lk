package by.sportliner.lk.core.service.analysis;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Map;

public class AttendancesAnalysis {

    private BigDecimal averageAttendance;

    private Map<LocalTime, Integer> attendanceByTime;

    public BigDecimal getAverageAttendance() {
        return averageAttendance;
    }

    public void setAverageAttendance(BigDecimal averageAttendance) {
        this.averageAttendance = averageAttendance;
    }

    public Map<LocalTime, Integer> getAttendanceByTime() {
        return attendanceByTime;
    }

    public void setAttendanceByTime(Map<LocalTime, Integer> attendanceByTime) {
        this.attendanceByTime = attendanceByTime;
    }
}
