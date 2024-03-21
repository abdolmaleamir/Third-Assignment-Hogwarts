import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private UUID accountID;
    private String username;
    private String password;


    @Override
    public String toString() { return super.toString(); }

    public void changeUsername(String newUsername) { username = newUsername; }

    public void changePassword(String newPassword) { password = newPassword; }
    public boolean validatePassword(String enteredPassword) {
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(enteredPassword);
        return matcher.find();
    }
}