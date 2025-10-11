package week3_OPL;

public class PasswordValidator {

    public String validate(String username, String password) {
        if (password.length() < 8) {
            return "TOOSHORT";
        }
        if (!containsAnyOf(password, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
            return "NOCAPITAL";
        }
        if (!containsAnyOf(password, "abcdefghijklmnopqrstuvwxyz")) {
            return "NOLOWER";
        }
        if (!containsAnyOf(password, "1234567890")) {
            return "NODIGIT";
        }
        if (!containsAnyOf(password, "[]%£&@#€$(){}<>/?+-*\\")) {
            return "NOSYMBOL";
        }
        if (password.contains(username)) {
            return "HASUSERNAME";
        }
        return "OK";
    }

    private boolean containsAnyOf(String text, String charsToFind) {
        for (char c : charsToFind.toCharArray()) {
            if (text.indexOf(c) != -1) return true;
        }
        return false;
    }
}
