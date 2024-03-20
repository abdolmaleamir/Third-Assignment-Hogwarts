import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher extends Account{
    private String password;
    private String username;
    private int lumos = 0;  //students can show their satisfaction of their teachers with this spell
    private String course = "";
    private double score;

    public Teacher(String username , String password , double score, String course){
        this.score = score;
        this.course = course;
        this.username = username;
        this.password = password;

    }

    @Override
    public String toString() {
        return (this.username + "&" + this.course + "&" +
                this.score + "&" + this.lumos + "&"
                + this.password);
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(enteredPassword);
        return matcher.find();
    }

    @Override
    public void changePassword(String newPassword) {
        super.changePassword(newPassword);
    }

    public void setVote(int lumos) { this.lumos = lumos; }

    public int getVote() { return lumos; }

    public void showProfile() {
        System.out.println("welcom");
        System.out.println(username +"........");
        System.out.println("Score: " + score);
        System.out.println("Taken Course: " + course);
        System.out.println("may the odds be in your favour");
    }


}