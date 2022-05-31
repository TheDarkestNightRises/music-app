package musicApp.client.views.updateSettings;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

import java.io.File;

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
  public TextArea descriptionField;
  @FXML
  public Label errorLabel1;
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
    viewModel.bindDescription(descriptionField.textProperty());
    viewModel.bindError(errorLabel.textProperty());
    viewModel.bindError1(errorLabel1.textProperty());
    viewModel.bindImage(profilePicture.imageProperty());
    viewModel.reset();
  }
  @FXML
  public void submitButtonPressed()
  {
    viewModel.submit();
  }
  @FXML
  public void choosePictureButtonPressed()
  {
    FileChooser chooser = new FileChooser();
    chooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
        new FileChooser.ExtensionFilter("PNG", "*.png")
    );
    File file = chooser.showOpenDialog(viewHandler.getStage());
    if(file != null)
      viewModel.choosePicture(file);
  }
  @FXML
  public void updatePictureButtonPressed()
  {
    viewModel.uploadPicture();

  }
  @FXML
  public void resetButtonPressed()
  {
    viewModel.reset();
  }
  @FXML
  public void submitPassword(){ emailField.requestFocus();}
  @FXML
  public void submitEmail(){ nicknameField.requestFocus();}
  @FXML
  public void submitNickname(){ submitButtonPressed();}
  @FXML
  public void backButtonPressed()
  {
    viewHandler.openMainMenu();
  }
}
