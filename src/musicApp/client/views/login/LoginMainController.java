package musicApp.client.views.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginMainController implements ViewController
{
  @FXML
  public TextField username;
  @FXML
  public PasswordField password;
  public Label errorLabel;
  private ViewHandler viewHandler;
  private LoginMainViewModel viewModel;


  @Override 
  public void init(ViewHandler vh, ViewModelFactory vmf,Object... args)
  {
    this.viewHandler = vh;
    this.viewModel = vmf.getLoginMainViewModel();
    username.textProperty().bindBidirectional(viewModel.usernameProperty());
    password.textProperty().bindBidirectional(viewModel.passwordProperty());
    viewModel.bindError(errorLabel.textProperty());
  }



  public void signInButtonPressed()
  {
    boolean isSignedIn = viewModel.signIn();
    if (isSignedIn) {
      //viewModel.setUser();please do not use
      viewHandler.openProfile(viewModel.getUser());
      //viewHandler.openUpdateSettings();
    }
  }

  public void signUpButtonPressed()
  {
    viewHandler.openSignUp();
  }


}

