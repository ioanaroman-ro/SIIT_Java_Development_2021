package Timetable;

public class Hour {
    public int hourDuration;
    public int breakTime;

    public Hour(int hourDuration, int breakTime) {
        this.hourDuration = hourDuration;
        this.breakTime = breakTime;
    }

    public int getHourDuration() {
        return hourDuration;
    }

    public void setHourDuration(int hourDuration) {
        this.hourDuration = hourDuration;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }

    @Override
    public String toString() {
        return "Hour{" +
                "hourDuration=" + hourDuration + " min " +
                ", breakTime=" + breakTime + "  min " +
                '}';
    }
}
