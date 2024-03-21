import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Account{
    private ArrayList<String> courses = new ArrayList<>();
    private String username;
    double score;
    private String password;
    private String group;

    public Student(String username , String password, String group , double grade){
        this.username = username;
        this.score = grade;
        this.password = password;
        this.group = group;

    }


    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String toString() {
        return ( this.username + "&" + this.group +
                "&" + this.score + "&" +
                this.courses + "&" + this.password);
    }

    public void showProfile() {
        System.out.println("welcome");
        System.out.println(username +".......");
        System.out.println("score: " + score);
        System.out.println("Taken Courses: " + courses);
        System.out.println("Hogwarts group: " + group);
        System.out.println("may the odds be ever in your favor");
    }

    public ArrayList<String> getCourses() { return courses; }

    @Override
    public boolean validatePassword(String enteredPassword) {
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(enteredPassword);
        return matcher.find();
    }

}