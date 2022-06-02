package musicApp.client.views.artistSignUp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

public class ArtistSignUpViewController implements ViewController
{
  @FXML
  private PasswordField password;
  @FXML
  private TextField username;
  @FXML
  private Label error;
  @FXML
  private PasswordField repeatPassword;
  @FXML
  private TextField email;
  private ViewHandler viewHandler;
  private ArtistSignUpViewModel viewModel;


  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
    viewHandler = vh;
    viewModel = vmf.getArtistSignUpViewModel();
    viewModel.bindPassword(password.textProperty());
    viewModel.bindUsername(username.textProperty());
    viewModel.bindError(error.textProperty());
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
    signUpPressed();
  }

  @FXML
  public void backToLogin()
  {
    viewHandler.openLogin();
  }

  @FXML
  protected void signUpPressed() {
    if(viewModel.registerValidation())
    {
      viewModel.createArtistUser();
      viewHandler.openLogin();
    }
  }
}
