package musicApp.client.views.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginMainController implements ViewController {
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public Label error;
    private ViewHandler viewHandler;
    private LoginMainViewModel viewModel;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.viewModel = vmf.getLoginMainViewModel();
        viewModel.bindError(error.textProperty());
        viewModel.bindUsername(username.textProperty());
        viewModel.bindPassword(password.textProperty());
    }


    public void signInButtonPressed() {
        boolean canSignedIn = viewModel.signIn();
        if (canSignedIn) {
            viewHandler.openMainMenu();
        }
    }

    public void signUpButtonPressed() {
        viewHandler.openSignUp();
    }

    public void artistSignUpButtonPressed() {
        viewHandler.openArtistSignUp();
    }


}

