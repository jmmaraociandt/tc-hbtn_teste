import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private String password;

    private boolean isMinLength(String string) {
        return string.length() >= 8;
    }

    private boolean isSpecialCharacter(String string) {
        Pattern specialCharacter = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher specialCharacterMatcher = specialCharacter.matcher(string);
        return specialCharacterMatcher.find();
    }

    public boolean checkUser() {
        return isMinLength(name) && !isSpecialCharacter(name);
    }

    public boolean checkPassword() {
        boolean capitalLetterFlag = false;
        boolean numberFlag = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                capitalLetterFlag = true;
            else if (Character.isDigit(password.charAt(i)))
                numberFlag = true;
        }

        return capitalLetterFlag && numberFlag && isSpecialCharacter(password) && isMinLength(password);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
