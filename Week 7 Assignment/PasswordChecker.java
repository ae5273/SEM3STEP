public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();

        if (length >= 10) {
            return "Strong";
        } else if (length >= 6) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {
        System.out.println("abcd -> " + new PasswordChecker("abcd").getStrength());
        System.out.println("abcdefgh -> " + new PasswordChecker("abcdefgh").getStrength());
        System.out.println("abcdefghij -> " + new PasswordChecker("abcdefghij").getStrength());
    }
}
