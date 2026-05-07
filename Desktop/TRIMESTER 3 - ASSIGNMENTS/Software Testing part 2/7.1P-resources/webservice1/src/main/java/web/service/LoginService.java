package web.service;

/**
 * Ayush Indapure - 224880003
 * Business logic for authentication
 */
public class LoginService {

    public static boolean login(String username, String password, String dob) {

        if (username == null || password == null || dob == null) {
            return false;
        }

        username = username.trim();
        password = password.trim();
        dob = dob.trim();

        // Hardcoded valid user (you can expand later for testing)
        String validUsername = "ayush";
        String validPassword = "qwerty12";
        String validDob = "2003-08-18";

        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }

        // Full validation (this is what your assignment wants)
        if (username.equals(validUsername)
                && password.equals(validPassword)
                && dob.equals(validDob)) {
            return true;
        }

        return false;
    }
}