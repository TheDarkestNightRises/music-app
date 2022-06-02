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
  public Label error;
  @FXML
  public TextArea descriptionField;
  @FXML
  public Label error1;
  @FXML
  public ImageView profilePicture;
  private ViewHandler viewHandler;
  private UpdateSettingsViewModel viewModel;

  /**
   * initialises the viewhandler, the view model and binds the controls
   * @param vh
   * @param vmf
   * @param args
   */
  @Override public void init(ViewHandler vh, ViewModelFactory vmf,Object... args)
  {
    this.viewHandler = vh;

    viewModel = vmf.getUpdateSettingsViewModel();
    viewModel.bindPassword(passwordField.textProperty());
    viewModel.bindNickname(nicknameField.textProperty());
    viewModel.bindEmail(emailField.textProperty());
    viewModel.bindDescription(descriptionField.textProperty());
    viewModel.bindError(error.textProperty());
    viewModel.bindError1(error1.textProperty());
    viewModel.bindImage(profilePicture.imageProperty());
    viewModel.reset();
  }

  /**
   * delegates submission of new information to the view model
   */
  @FXML
  public void submitButtonPressed()
  {
    viewModel.submit();
  }

  /**
   * opens file chooser and lets the user choose a file of extention .jpg or .png, then sends the file to the view model
   */
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

  /**
   * delegates upload of picture to the view model
   */
  @FXML
  public void updatePictureButtonPressed()
  {
    viewModel.uploadPicture();

  }

  /**
   * resets the view
   */
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
  /**
   * onAction method of a button that opens the Main Menu
   */
  @FXML
  public void backButtonPressed()
  {
    viewHandler.openMainMenu();
  }
}
