package musicApp.client.views.artistSignUp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.signup.SignUpViewModel;

public class ArtistVSignUpViewController implements ViewController
{
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
    if(viewModel.canCreateUser())
    {
      viewModel.createUser();
      viewHandler.openLogin();
    }
  }
}
