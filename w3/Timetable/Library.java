package Timetable;

public class Library extends Room{
    public int totalBooks;
    public int availableBooks;

    public Library(String roomName, int roomCapacity, int availableSeats, int totalBooks, int availableBooks) {
        super(roomName, roomCapacity, availableSeats);
        this.totalBooks = totalBooks;
        this.availableBooks = availableBooks;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    @Override
    public String toString() {
        return "Library{" +
                "totalBooks=" + totalBooks +
                ", availableBooks=" + availableBooks +
                ", roomName='" + roomName + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", occupied=" + occupied +
                ", occupiedHours=" + occupiedHours +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
