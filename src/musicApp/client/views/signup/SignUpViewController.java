package musicApp.client.views.signup;

import javafx.scene.control.Label;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import javax.swing.*;

public class SignUpViewController implements ViewController {
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private Label errorLabel;
    @FXML
    private PasswordField repeatPassword;
    @FXML
    private TextField email;
    private ViewHandler viewHandler;
    private SignUpViewModel viewModel;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
        viewHandler = vh;
        viewModel = vmf.getSignUpViewModel();
        viewModel.bindPassword(password.textProperty());
        viewModel.bindUsername(username.textProperty());
        viewModel.bindError(errorLabel.textProperty());
        viewModel.bindRepeatPassword(repeatPassword.textProperty());
        viewModel.bindEmail(email.textProperty());
    }

    @FXML
    public void submitEmail(){ username.requestFocus();}

    @FXML
    public void submitUsername() {
        password.requestFocus();
    }


    @FXML
    public void submitPassword() {
        repeatPassword.requestFocus();
    }

    @FXML
    public void submitRepeatPassword()
    {
        signUpButtonPressed();
    }

   @FXML
    public void backToLogin()
   {
       viewHandler.openLogin();
   }

    @FXML
    protected void signUpButtonPressed() {
       if(viewModel.canCreateUser()) //TODO: IF CREATE USER CREATE USER
       {
           viewModel.createUser();
           viewHandler.openLogin();
       }
    }

}

