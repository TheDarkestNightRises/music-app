package musicApp.client.views.updateSettingsS;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UpdateSettingsViewController implements ViewController
{
  @FXML
  public PasswordField passwordField;
  @FXML
  public TextField nicknameField;
  @FXML
  public TextField emailField;
  @FXML
  public Label errorLabel;
  @FXML
  public ImageView profilePicture;
  private ViewHandler viewHandler;
  private UpdateSettingsViewModel viewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf,Object... args)
  {
    this.viewHandler = vh;

    viewModel = vmf.getUpdateSettingsViewModel();
    viewModel.bindPassword(passwordField.textProperty());
    viewModel.bindNickname(nicknameField.textProperty());
    viewModel.bindEmail(emailField.textProperty());
    viewModel.bindError(errorLabel.textProperty());
    viewModel.bindImage(profilePicture.imageProperty());
    viewModel.reset();
  }
  public void submitButtonPressed()
  {
    
  }
  public void choosePictureButtonPressed()
  {

  }
}
