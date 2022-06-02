package musicApp.client.views.signup;

import javafx.scene.control.Label;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



/**
 * This is the controller for register as an user view
 */
public class SignUpViewController implements ViewController {
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repeatPassword;
    @FXML
    private Label error;

    private ViewHandler viewHandler;
    private SignUpViewModel viewModel;

    /**
     *  The constructor of this controller. It calls the view model to do bindings
     * @param vh
     * @param vmf
     * @param args
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        viewHandler = vh;
        viewModel = vmf.getSignUpViewModel();
        viewModel.bindPassword(password.textProperty());
        viewModel.bindUsername(username.textProperty());
        viewModel.bindError(error.textProperty());
        viewModel.bindRepeatPassword(repeatPassword.textProperty());
        viewModel.bindEmail(email.textProperty());
    }

    /**
     * This method is used to go to the username field when pressing enter
     */
    @FXML
    public void submitEmail() {
        username.requestFocus();
    }

    /**
     * This method is used to go to the password field when pressing enter
     */
    @FXML
    public void submitUsername() {
        password.requestFocus();
    }

    /**
     * This method is used to go to the repeatPassword field when pressing enter
     */
    @FXML
    public void submitPassword() {
        repeatPassword.requestFocus();
    }

    /**
     * This method is used to create an account with the information given
     */
    @FXML
    public void submitRepeatPassword() {
        signUpButtonPressed();
    }

    /**
     * This method is used for going back to log in window
     */
    @FXML
    public void backToLogin() {
        viewHandler.openLogin();
    }

    /**
     * This method is used for going back to log in window
     */
    @FXML
    protected void signUpButtonPressed() {
        if (viewModel.registerValidation()) {
            viewModel.createUser();
            viewHandler.openLogin();
        }
    }

}

