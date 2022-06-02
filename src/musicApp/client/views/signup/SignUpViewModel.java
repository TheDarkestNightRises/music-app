package musicApp.client.views.signup;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import musicApp.client.model.register.SignUpManager;


/**
 * sign up view model responsible for creating an user account
 */
public class SignUpViewModel {
    private final SignUpManager signUpManager;
    private final StringProperty email;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty repeatPassword;
    private final StringProperty error;



    /**
     * This is the constructor of the SignUpViewModel
     * @param signUpManager to create the user
     *
     */
    public SignUpViewModel(SignUpManager signUpManager) {
        this.signUpManager = signUpManager;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.repeatPassword = new SimpleStringProperty("");

    }

    /**
     * This method is used to create the user
     * @return true if the user was successfully created
     */
    public boolean createUser() {
        try {
            signUpManager.addUser(username.get(), password.get(), email.get());
            reset();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method is used to check if the email is valid
     * @return true if the email is not valid and false if it is
     */
    private boolean emailNotValid() {
        return signUpManager.emailNotValid(email.get());
    }

    /**
     * This method check if the username already exists among the accounts
     * @return true if the username already exists or false if it does not exist
     */
    public boolean UsernameExists() {
        return signUpManager.usernameExists(username.get());
    }

    /**
     * This method check is the password has any digits
     * @return true if it does not have and false if it has
     */
    public boolean noDigits() {
        return signUpManager.noDigits(password.get());
    }

    /**
     * This method checks if the password has at least one upper character
     * @return true if it does not and false if it does
     */
    public boolean noUpper() {
        return signUpManager.noUpper(password.get());
    }

    public void bindUsername(StringProperty property) {
        username.bindBidirectional(property);
    }

    public void bindPassword(StringProperty property) {
        password.bindBidirectional(property);
    }

    public void bindError(StringProperty property) {
        error.bindBidirectional(property);
    }

    /**
     * This is used to reinitialize every field to null
     */
    public void reset() {
        username.set("");
        password.set("");
        error.set("");
        repeatPassword.set("");
        email.set("");
    }

    public void bindRepeatPassword(StringProperty property) {
        repeatPassword.bindBidirectional(property);
    }

    public void bindEmail(StringProperty property) {
        email.bindBidirectional(property);
    }

    public boolean canCreateUser() {
        return createUser();
    }

    /**
     * This method creates the user if all the input is valid
     * @return true if the user can be created
     */
    public boolean registerValidation() {
        if ("".equals(password.get()) && "".equals(username.get()) && "".equals(email.get())
                && "".equals(repeatPassword.get())) {
            error.set("No data inserted!");
            return false;
        }


        if ("".equals(username.get())) {
            error.set("Username should not be null!");
            return false;
        }


        if (UsernameExists()) {
            error.set("Username already exists!");
            return false;
        }


        if ("".equals(password.get())) {
            error.set("Password should not be null!");
            return false;
        }

        if ("".equals(email.get())) {
            error.set("Email should not be null!");
            return false;
        }

        if (password.get().length() < 8) {
            error.set("Password must contain at least 8 characters!");
            return false;
        }

        if (noDigits()) {
            error.set("Password must contain at least one digit!");
            return false;
        }

        if (noUpper()) {
            error.set("Password must contain at least one uppercase!");
            return false;
        }

        if (emailNotValid()) {
            error.set("Email is not valid!");
            return false;
        }

        if (!password.toString().equals(repeatPassword.toString())) {
            error.set("Password does not match!");
            password.set("");
            repeatPassword.set("");
            return false;
        }
        return true;
    }
}
