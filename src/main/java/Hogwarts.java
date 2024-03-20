import java.util.ArrayList;
import java.util.Arrays;

public class Hogwarts {

    public ArrayList<String> studentsList = new ArrayList<>();
    public ArrayList<String> coursesList = new ArrayList<>();
    public ArrayList<String> teachersList = new ArrayList<>();


    public void viewAllTeachers() {
        System.out.println("    NAME  , " +
                "COURSE ,   " +
                "SCORE\n");
        for (int i = 0; i < teachersList.size(); i++) {
            String teacher = teachersList.get(i);
            String[] parts = teacher.split(String.valueOf(";"));
            System.out.print((i + 1) + ". ");
            for (int j = 0; j < parts.length - 1; j++) {
                System.out.print(parts[j] + "   ");
            }
            System.out.println();
        }
    }


    public void viewAllStudents() {
        System.out.println("   NAME ," +
                "   HOUSE ,  " +
                " GRADE ,   " + " COURSES\n");
        for (int i = 0; i < studentsList.size(); i++) {
            String student = studentsList.get(i);
            String[] parts = student.split(String.valueOf(";"));
            System.out.print((i + 1) + ". ");
            for (int j = 0; j < parts.length - 1; j++) {
                System.out.print(parts[j] + "   ");
            }
            System.out.println();
        }
    }

    public void teacherAppend(String enteredTeacher) {
        teachersList.add(enteredTeacher);
    }

    public void studentsAppend(String enteredStudent) {
        studentsList.add(enteredStudent);
    }


    public void defaultCourses() {
        coursesList.addAll(Arrays.asList("potions", "divination"
                , "astronomy", "charms"
                , "herbology"));
    }

    public void viewAllCourses() {
        for (int i = 0; i < coursesList.size(); i++) {
            String course = coursesList.get(i);
            System.out.println((i + 1) + ". " + course);
        }
    }

}

