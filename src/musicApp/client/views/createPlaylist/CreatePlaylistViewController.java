package musicApp.client.views.createPlaylist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.signup.SignUpViewModel;

public class CreatePlaylistViewController implements ViewController
{

  @FXML
  private TextField title;
  @FXML
  private Label errorLabel;
  @FXML
  private TextField description;
  private ViewHandler viewHandler;
  private CreatePlaylistViewModel viewModel;


  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
    viewHandler = vh;
    viewModel = vmf.getCreatePlaylistViewModel();
    viewModel.bindTitle(title.textProperty());
    viewModel.bindDescription(description.textProperty());
    viewModel.bindError(errorLabel.textProperty());
  }

  @FXML
  public void submitTitle() {
    description.requestFocus();
  }

  @FXML
  public void backToProfile()
  {
    viewHandler.openProfile();
  }

  @FXML
  protected void createButtonPressed() {
    viewModel.createPlaylist();
  }
}
