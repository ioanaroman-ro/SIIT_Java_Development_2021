package Timetable;


public class Laboratory extends Room{
    public int workStations;

    public Laboratory(String roomName, int roomCapacity, int availableSeats) {
        super(roomName, roomCapacity, availableSeats);
    }

    public int getWorkStations() {
        return workStations;
    }

    public void setWorkStations(int workStations) {
        this.workStations = workStations;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "workStations=" + workStations +
                ", roomName='" + roomName + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", occupied=" + occupied +
                ", occupiedHours=" + occupiedHours +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
