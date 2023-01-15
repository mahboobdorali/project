package ir.maktab.validation;

import ir.maktab.exception.InputInvalidException;
public class Validate {
    public static void emailIsValid(String email) throws InputInvalidException {
        if (!email.equals("") && email.matches("^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a=zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-z]{2,7}$"))
            return;
        throw new InputInvalidException("your email address is not valid");
    }

    public static void passwordIsValid(String password) throws InputInvalidException {
        if (!password.equals("") && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%&])(?=\\S+$).{8}$"))
            return;
        throw new InputInvalidException("your password must be a combination of letters and numbers with " +
                "a length 8!!");
    }
}
