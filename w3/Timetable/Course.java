package Timetable;

public class Course {
    public String courseName;
    public int noOfStudents;
    public int lengthHoursCourse;
    public int lengthHoursLaboratory;
    public boolean hasLaboratory;

    public Course(String courseName, int noOfStudents, boolean hasLaboratory) {
        this.courseName = courseName;
        this.noOfStudents = noOfStudents;
        this.hasLaboratory = hasLaboratory;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public int getLengthHoursCourse() {
        return lengthHoursCourse;
    }

    public void setLengthHoursCourse(int lengthHoursCourse) {
        this.lengthHoursCourse = lengthHoursCourse;
    }

    public int getLengthHoursLaboratory() {
        return lengthHoursLaboratory;
    }

    public void setLengthHoursLaboratory(int lengthHoursLaboratory) {
        this.lengthHoursLaboratory = lengthHoursLaboratory;

    }

    public boolean isHasLaboratory() {
        return hasLaboratory;
    }

    public void setHasLaboratory(boolean hasLaboratory) {
        this.hasLaboratory = hasLaboratory;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", noOfStudents=" + noOfStudents +
                ", lengthHoursCourse=" + lengthHoursCourse +
                ", lengthHoursLaboratory=" + lengthHoursLaboratory +
                ", hasLaboratory=" + hasLaboratory +
                '}';
    }

}

