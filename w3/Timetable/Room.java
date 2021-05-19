package Timetable;

public class Room {
    public String roomName;
    public int roomCapacity;
    public boolean occupied = false;
    public int occupiedHours;
    public int availableSeats;

    public Room(String roomName, int roomCapacity, int availableSeats) {
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.availableSeats = availableSeats;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getOccupiedHours() {
        return occupiedHours;
    }

    public void setOccupiedHours(int occupiedHours) {
        this.occupiedHours = occupiedHours;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        if (occupied = true){
            System.out.println("No more available seats");
        } else {
            this.availableSeats = availableSeats;
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", occupied=" + occupied +
                ", occupiedHours=" + occupiedHours +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
