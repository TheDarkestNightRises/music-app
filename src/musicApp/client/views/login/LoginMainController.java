package musicApp.client.views.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * This controller is used for login
 */
public class LoginMainController implements ViewController {
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public Label error;
    private ViewHandler viewHandler;
    private LoginMainViewModel viewModel;


    /**
     * This is the constructor of the controler . It calls the viewmodel to bind elements declared here
     * @param vh - to open views
     * @param vmf - to initialize view model
     * @param args -
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.viewModel = vmf.getLoginMainViewModel();
        viewModel.bindError(error.textProperty());
        viewModel.bindUsername(username.textProperty());
        viewModel.bindPassword(password.textProperty());
    }

    /**
     * This method is linked with the Sign In button. When the button is pressed this
     * method will be called. It checks if the user can sign and if he can then
     * it will open the main menu
     */
    public void signInButtonPressed() {
        boolean canSignedIn = viewModel.signIn();
        if (canSignedIn) {
            viewHandler.openMainMenu();
        }
    }

    /**
     * This method opens the sign up view
     */
    public void signUpButtonPressed() {
        viewHandler.openSignUp();
    }

    /**
     * This method opens the artist sign up view
     */
    public void artistSignUpButtonPressed() {
        viewHandler.openArtistSignUp();
    }


}

