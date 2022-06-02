package musicApp.client.views.signup;

import javafx.scene.control.Label;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    @FXML
    public void submitEmail() {
        username.requestFocus();
    }

    @FXML
    public void submitUsername() {
        password.requestFocus();
    }


    @FXML
    public void submitPassword() {
        repeatPassword.requestFocus();
    }

    @FXML
    public void submitRepeatPassword() {
        signUpButtonPressed();
    }

    @FXML
    public void backToLogin() {
        viewHandler.openLogin();
    }

    @FXML
    protected void signUpButtonPressed() {
        if (viewModel.registerValidation()) {
            viewModel.createUser();
            viewHandler.openLogin();
        }
    }

}

