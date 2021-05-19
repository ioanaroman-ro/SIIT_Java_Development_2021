package Timetable;

import java.util.Arrays;

public class TimetableMain {
    public static void main(String[] args) {
        Faculty infoIasi = new Faculty("Informatica", "Iasi");
        Hour hour = new Hour(50, 10);
        int laboratoryTime = hour.getBreakTime() + hour.getHourDuration();
        int courseTime = laboratoryTime * 2;
        int dayTime = laboratoryTime * 8;

        Course[] activeCourses = loadCourses();

        for (Course course : activeCourses) {
            setCourseHours(course, laboratoryTime, courseTime);
        }

        Laboratory[] activeLaboratories = loadLaboratories();
        LectureTheater[] activeLectureTheatre = loadLectureTheatre();
        Library[] activeLibraries = loadLibraries();

        for (Laboratory lab : activeLaboratories) {
            if (lab.getRoomCapacity() % 2 == 0) {
                lab.setWorkStations(lab.getRoomCapacity() / 2);
            } else {
                lab.setWorkStations(lab.getRoomCapacity() / 2 + 1);
            }
        }

        activeLectureTheatre[0].hasProjector = true;

        for (
                Library library : activeLibraries) {
            if (library.getRoomCapacity() > library.getAvailableBooks()) {
                library.setOccupied(true);
            }
        }

        System.out.println(Arrays.toString(activeCourses));
        System.out.println(Arrays.toString(activeLaboratories));
        System.out.println(Arrays.toString(activeLectureTheatre));
        System.out.println(Arrays.toString(activeLibraries));


    }

    private static LectureTheater[] loadLectureTheatre() {
        LectureTheater chemistryTheater = new LectureTheater("ChemistryTheater", 50, 50);
        LectureTheater physicsTheater = new LectureTheater("PhisicsTheater", 50, 50);
        return new LectureTheater[]{chemistryTheater, physicsTheater};
    }

    private static Laboratory[] loadLaboratories() {
        Laboratory chemistryLab = new Laboratory("ChemistryLab", 25, 25);
        Laboratory physicsLab = new Laboratory("PhisicsLab", 26, 26);
        return new Laboratory[]{chemistryLab, physicsLab};
    }

    private static Library[] loadLibraries() {
        Library library1 = new Library("Library", 50, 100, 80, 50);
        Library library2 = new Library("Library", 50, 100, 80, 20);
        return new Library[]{library1, library2};
    }

    private static void setCourseHours(Course course, int laboratoryTime, int courseTime) {
        course.setLengthHoursCourse(courseTime);
        if (course.isHasLaboratory()) {
            course.setLengthHoursLaboratory(laboratoryTime);
        } else {
            course.setLengthHoursLaboratory(0);
        }

    }

    private static Course[] loadCourses() {
        Course chimie1 = new Course("Chimie1", 25, true);
        Course chimie2 = new Course("Chimie2", 25, true);
        Course fizica1 = new Course("Fizica1", 25, true);
        Course fizica2 = new Course("Fizica2", 25, true);
        Course info = new Course("Info", 25, false);
        return new Course[]{chimie1, chimie2, fizica1, fizica2, info};
    }


}
