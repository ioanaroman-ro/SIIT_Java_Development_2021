package Timetable;


import java.util.Arrays;

public class Faculty {
    public String name;
    public String address;
    Room[] rooms;
    public int maxCourses;

    public Faculty(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public int getMaxCourses() {
        return maxCourses;
    }

    public void setMaxCourses(int maxCourses) {
        this.maxCourses = maxCourses;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + Arrays.toString(rooms) +
                ", maxCourses=" + maxCourses +
                '}';
    }
}
