import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Assistant assistant = new Assistant();
    public static Hogwarts hogwarts = new Hogwarts();





    public static void runMenu() {
        System.out.println("WELCOME TO HOGWARTS OR SURVIVE IN HOGWARTS");
        Scanner in = new Scanner(System.in);
        System.out.println("1.Hogwarts Management");
        System.out.println("2.Assistant Management");
        System.out.println("3.Teacher Management");
        System.out.println("4.Student Management");
        System.out.println("5.Quit");
        switch (in.next()) {
            case "1":
                hogwartsMenu();
                break;
            case "2":
                assistantMenu();
                break;
            case "3":
                teacherMenu();
                break;
            case "4":
                studentMenu();
                break;
            case "5":
                break;
            default:
                System.out.println("Invalid input");
                runMenu();
                break;
        }
    }

    public static String quiz() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose one of the colors :");
        System.out.println("1.red and gold");
        System.out.println("yellow and black");
        System.out.println("blue and bronze");
        System.out.println("green and silver");
        String house = "";
        switch (in.next()) {
            case "1":
                house = "Gryffindor";
                break;
            case "2":
                house = "Hufflepuff";
                break;
            case "3":
                house = "Ravenclaw";
                break;
            case "4":
                house = "Slytherin";
                break;
            default:
                quiz();
        } return house;
    }

    public static String hashedPassword(String enteredPassword) {
        int hashNum = enteredPassword.hashCode();
        return Integer.toString(hashNum);
    }

    public static void hogwartsMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("choose : ");
        System.out.println("1.reveal the teachers");
        System.out.println("2.reveal the students");
        System.out.println("3.reveal the courses");
        System.out.println("4.Quit");
        switch (in.next()) {
            case "1":
                hogwarts.viewAllTeachers();
                break;
            case "2":
                hogwarts.viewAllStudents();
                break;
            case "3":
                hogwarts.viewAllCourses();
                break;
            case "4":
                runMenu();
                break;
            default:
                System.out.println("Invalid input");
                break;
        } hogwartsMenu();
    }

    public static void assistantMenu() {
        Scanner in = new Scanner(System.in);
        System.out.print("Username: ");
        String username = in.next();
        System.out.print("Password: ");
        String password = hashedPassword(in.next());
        if (assistant.validatePassword(password) && assistant.validateUsername(username)) {
            assistantMenuLog();
        } else {  System.out.println("Wrong username or password.");
        }
        runMenu();
    }

    public static void assistantMenuLog() {            //master and admin are the same thing
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome master");
        System.out.println("1.handling teachers");
        System.out.println("2.handling students");
        System.out.println("3.handling courses");
        System.out.println("4.Quit");
        switch (in.next()) {
            case "1":
                hogwarts.teachersList = assistant.adjustTeachersList();
                break;
            case "2":
                hogwarts.studentsList = assistant.adjustStudentList();
                break;
            case "3":
                hogwarts.coursesList = assistant.adjustCourseList();
                break;
            case "4":
                System.out.println("____________________");
                System.out.println("1.teacher requests");
                System.out.println("2.student request");
                System.out.println("3.Quit");
                switch (in.next()){
                    case "1":
                        requestTeacher();
                        break;
                    case "2":
                        requestStudent();
                        break;
                    default:
                        break;
                }
                break;
            case "5":
                runMenu();
                break;
            default:
                break;
        } assistantMenuLog();
    }

    public static void requestTeacher(){
        Scanner in = new Scanner(System.in);
        assistant.showRequestTeacher();
        System.out.println("choose one : ");
        int index = in.nextInt();
        System.out.println("choose one : ");
        System.out.println("1.Accept");
        System.out.println("2.Remove");
        System.out.println("3.Quit");
        switch (in.next()){
            case "1":
                hogwarts.teachersList.add(assistant.wantingteachers.get(index - 1));
                assistant.teachersList.add(assistant.wantingteachers.get(index - 1));
                assistant.wantingteachers.remove(index - 1);
                break;
            case "2":
                assistant.wantingteachers.remove(index - 1);
            case "3":
                assistantMenuLog();
                break;
            default:
                requestTeacher();
                break;
        }
    }

    public static void requestStudent(){
        Scanner in = new Scanner(System.in);
        assistant.showRequestStudent();
        System.out.println("choose one : ");
        int index = in.nextInt();
        System.out.println("choose one : ");
        System.out.println("1.Accept");
        System.out.println("2.Remove");
        System.out.println("3.Quit");
        switch (in.next()){
            case "1":
                hogwarts.studentsList.add(assistant.wantingstudents.get(index - 1));
                assistant.studentsList.add(assistant.wantingstudents.get(index - 1));
                assistant.wantingstudents.remove(index - 1);
                break;
            case "2":
                assistant.wantingstudents.remove(index - 1);
            case "3":
                assistantMenuLog();
                break;
            default:
                requestStudent();
                break;
        }
    }

    public static void teacherMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Log in");
        System.out.println("2.signup");
        System.out.println("3.quit");
        String opt = in.next();
        if (opt.equals("1")) {
            System.out.println("Username: ");
            String username = in.next();
            Teacher teacher = teacherFinder(username);
            System.out.println("Password: ");
            String password = hashedPassword(in.next());
            if(teacher.validatePassword(password)) {
                teacherMenuLog(teacher, username);
            }
            else{
                System.out.println("Wrong Password");
            }
        } else if (opt.equals("2")) {
            System.out.print("Username: ");
            String username = in.next();
            System.out.print("Password: ");
            String password = hashedPassword(in.next());
            double score = 0;
            System.out.println("Please select a course you want to teach:");
            hogwarts.viewAllCourses();
            int index = in.nextInt();
            String course = hogwarts.coursesList.get(index - 1);
            Teacher teacher = new Teacher(username, password, score, course);
            assistant.wantingteachers.add(teacher.toString());
            System.out.println("Your request sent");
            runMenu();
        } else if (opt.equals("3")) {
            runMenu();
        } else {
            System.out.println("Invalid input.");
            teacherMenu();
        }

    }

    public static void teacherMenuLog(Teacher teacher , String username){
        Scanner in = new Scanner(System.in);
        teacher.showProfile();
        System.out.println("____________________");
        System.out.println("1.Change Username");
        System.out.println("2.Change Password");
        System.out.println("3.Quit");
        switch (in.next()) {
            case "1":
                teacherReplace(username);
                System.out.println("New Username: ");
                teacher.changeUsername(in.next());
                hogwarts.teachersList.add(teacher.toString());
                assistant.teachersList.add(teacher.toString());
                teacherMenuLog(teacher , username);
                break;
            case "2":
                teacherReplace(username);
                System.out.println("New Password: ");
                teacher.changePassword(in.next());
                hogwarts.teachersList.add(teacher.toString());
                assistant.teachersList.add(teacher.toString());
                teacherMenuLog(teacher , username);
                break;
            case "3":
                runMenu();
                break;
            default:
                teacherMenuLog(teacher , username);
                break;

        }
    }

    public static void studentMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Log in");
        System.out.println("2.sign up");
        System.out.println("3.Quit");
        String opt = in.next();
        if (opt.equals("1")) {
            System.out.println("Username: ");
            String username = in.next();
            Student student = studentFinder(username);
            System.out.println("Password: ");
            String password = hashedPassword(in.next());
            if(student.validatePassword(password)) {
                studentMenuLog(student, username);
            }
            else{
                System.out.println("Wrong Password");
            }
        } else if (opt.equals("2")) {
            System.out.print("Username: ");
            String username = in.next();
            System.out.print("Password: ");
            String password = hashedPassword(in.next());
            String house = quiz();
            double grade = 0;
            Student student = new Student(username, password, house, grade);
            assistant.wantingstudents.add(student.toString());
            System.out.println("Your request sent");
            runMenu();
        } else if (opt.equals("3")) {
            runMenu();
        } else {
            System.out.println("Invalid input.");
            studentMenu();
        }
    }

    public static void studentMenuLog(Student student, String username){
        Scanner in = new Scanner(System.in);
        student.showProfile();
        System.out.println("____________________");
        System.out.println("1.Change Username");
        System.out.println("2.Change Password");
        System.out.println("3.handling courses");
        System.out.println("4.Quit");
        switch (in.next()) {
            case "1":
                studentReplace(username);
                System.out.println("New Username: ");
                student.changeUsername(in.next());
                hogwarts.studentsList.add(student.toString());
                assistant.studentsList.add(student.toString());
                studentMenuLog(student,username);
                break;
            case "2":
                studentReplace(username);
                System.out.println("New Password: ");
                student.changePassword(in.next());
                hogwarts.studentsList.add(student.toString());
                assistant.studentsList.add(student.toString());
                studentMenuLog(student,username);
                break;
            case "3":
                studentReplace(username);
                adjustCourses(student);
                studentMenuLog(student,username);
                break;
            case "4":
                runMenu();
                break;
        }

    }

    public static void adjustCourses(Student student) {
        System.out.println("Taken Courses: " + student.getCourses());
        Scanner in = new Scanner(System.in);
        System.out.println("Please select a course: ");
        hogwarts.viewAllCourses();
        int index = in.nextInt();
        ArrayList<String> courses = student.getCourses();
        courses.add(hogwarts.coursesList.get(index - 1));
        hogwarts.studentsAppend(student.toString());
        assistant.studentsAppend(student.toString());
    }

    public static void studentReplace(String username) {
        int i = 0;
        for (String student : hogwarts.studentsList) {
            Pattern pattern = Pattern.compile("\\w*" + username + "\\w*");
            Matcher matcher = pattern.matcher(student);
            if (matcher.find()) {
                hogwarts.studentsList.remove(i);
                assistant.studentsList.remove(i);
                break;
            } i++;
        }
    }

    public static void teacherReplace(String username) {
        int i = 0;
        for (String teacher : hogwarts.teachersList) {
            Pattern pattern = Pattern.compile("\\w*" + username + "\\w*");
            Matcher matcher = pattern.matcher(teacher);
            if (matcher.find()) {
                hogwarts.teachersList.remove(i);
                assistant.teachersList.remove(i);
                break;
            }  i++;
        }
    }

    public static Teacher teacherFinder( String username) {
        for (String name : hogwarts.teachersList) {
            Pattern pattern = Pattern.compile("\\w*" + username + "\\w*");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                String[] parts = name.split(String.valueOf(";"));
                String course = parts[1];
                double score = Double.parseDouble(parts[2]);
                String password = parts[3];
                Teacher teacher = new Teacher(username, password, score, course);
                return teacher;
            } else {
                System.out.println("Username not found");
            }
        } return null;
    }
    public static Student studentFinder(String username){
        for (String name : hogwarts.studentsList) {
            Pattern pattern = Pattern.compile("\\w*" + username + "\\w*");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                String[] parts = name.split(String.valueOf(";"));
                String house = parts[1];
                double grade = Double.parseDouble(parts[2]);
                String password = parts[4];
                Student student = new Student(username , password, house , grade);
                if(!parts[3].equals("[]")){
                    String list = parts[3].substring(1 , parts.length - 1);
                    String[] listObj = list.split(String.valueOf(","));
                    ArrayList<String> courses = student.getCourses();
                    for (int i = 0; i < parts.length; i++) {
                        if (listObj[i].charAt(0) == ' ') {
                            courses.add(listObj[i].substring(1));
                        } else {
                            courses.add(listObj[i]);
                        }
                    }
                }
                return student;
            } else { System.out.println("Username not found"); }
        } return null;
    }


    public static void main(String[] args) {
        hogwarts.defaultCourses();
        assistant.defaultCourses();
        runMenu();
    }
}