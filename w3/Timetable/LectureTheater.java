package Timetable;

public class LectureTheater extends Room{
    public boolean hasProjector;

    public LectureTheater(String roomName, int roomCapacity, int availableSeats) {
        super(roomName, roomCapacity, availableSeats);
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    @Override
    public String toString() {
        return "LectureTheater{" +
                ", roomName='" + roomName + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", occupied=" + occupied +
                ", occupiedHours=" + occupiedHours +
                ", availableSeats=" + availableSeats +
                "hasProjector=" + hasProjector +
                '}';
    }
}
