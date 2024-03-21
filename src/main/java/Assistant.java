import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assistant extends Hogwarts {
    public ArrayList<String> wantingteachers = new ArrayList<>();
    public ArrayList<String> wantingstudents = new ArrayList<>();
    private String username = "harrypotter";
    private final String password = "76856734";

    @Override
    public void viewAllTeachers() {
        super.viewAllTeachers();
        //todo
    }

    @Override
    public void viewAllStudents() {
        super.viewAllStudents();
    }

    @Override
    public void viewAllCourses() {
        super.viewAllCourses();
    }

    @Override
    public void teacherAppend(String enteredTeacher) {
        super.teacherAppend(enteredTeacher);
    }

    @Override
    public void studentsAppend(String enteredStudent) {
        super.studentsAppend(enteredStudent);
    }


    public ArrayList<String> adjustCourseList() {
        Scanner in = new Scanner(System.in);
        viewAllCourses();
        System.out.println("1.Add");
        System.out.println("2.Remove");
        System.out.println("Exit");
        switch (in.next()) {
            case "1":
                viewAllCourses();
                System.out.print("___________________");
                System.out.println("name the course you want to add please : ");
                String courseName = in.next();
                coursesList.add(courseName);
                System.out.println("it is done");
                System.out.println("the course was added");
                adjustCourseList();
                break;
            case "2":
                viewAllCourses();
                System.out.println("_____________________");
                System.out.println("would you select the one you want to remove ? ");
                int index = in.nextInt();
                coursesList.remove(index - 1);
                System.out.println("it is done ");
                System.out.println("the course is removed ");
                adjustCourseList();
                break;
            case "3":
                break;
            default:
                adjustCourseList();
                break;
        }
        return coursesList;
    }

    public ArrayList<String> adjustTeachersList() {
        Scanner in = new Scanner(System.in);
        viewAllTeachers();
        System.out.println("_________________");
        System.out.println("1.Remove");
        System.out.println("2.Out");
        switch (in.next()) {
            case "1":
                viewAllTeachers();
                System.out.println("would you select the one you want to remove ?");
                int index = in.nextInt();
                teachersList.remove(index - 1);
                System.out.println("it is done");
                System.out.println("the teacher is removed");
                adjustTeachersList();
                break;
            case "2":
                break;
            default:
                adjustTeachersList();
                break;
        }
        return teachersList;
    }

    public ArrayList<String> adjustStudentList() {
        Scanner in = new Scanner(System.in);
        viewAllStudents();
        System.out.println("_____________________");
        System.out.println("1.Remove");
        System.out.println("2.Exit");
        switch (in.next()) {
            case "1":
                viewAllStudents();
                System.out.println("would you select the one you want to remove ?");
                int index = in.nextInt();
                studentsList.remove(index - 1);
                System.out.println("Removed Successfully");
                adjustStudentList();
                break;
            case "2":
                break;
            default:
                adjustStudentList();
                break;
        }
        return studentsList;
    }

    public void showRequestTeacher() {
        for (int j = 0; j < wantingteachers.size(); j++) {
            System.out.println((j + 1) + ", " + wantingteachers.get(j));
        }
    }

    public void showRequestStudent() {
        for (int i = 0; i < wantingstudents.size(); i++) {
            String student = wantingstudents.get(i);
            System.out.println((i + 1) + ". " + student);
        }
    }

    public boolean validatePassword(String enteredPassword) {
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(enteredPassword);
        return matcher.find();
    }

    public boolean validateUsername(String enteredUsername) {
        Pattern pattern = Pattern.compile(username);
        Matcher matcher = pattern.matcher(enteredUsername);
        return matcher.find();
    }


    public ArrayList<String> getRequestsStudent() {
        return wantingstudents;
    }

    public ArrayList<String> getRequestsTeacher() {
        return wantingteachers;
    }
}