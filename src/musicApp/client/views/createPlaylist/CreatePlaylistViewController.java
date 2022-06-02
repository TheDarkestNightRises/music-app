package musicApp.client.views.createPlaylist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

public class CreatePlaylistViewController implements ViewController
{

  @FXML
  private TextField title;
  @FXML
  private Label error;
  @FXML
  private TextArea description;
  private ViewHandler viewHandler;
  private CreatePlaylistViewModel viewModel;


  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
    viewHandler = vh;
    viewModel = vmf.getCreatePlaylistViewModel();
    viewModel.bindTitle(title.textProperty());
    viewModel.bindDescription(description.textProperty());
    viewModel.bindError(error.textProperty());
    System.out.println("binded");
  }

  @FXML
  public void submitTitle() {
    description.requestFocus();
  }

  @FXML
  public void back()
  {
    viewHandler.openMainMenu();
  }

  @FXML
  protected void createButtonPressed() {
    viewModel.createPlaylist();
    viewHandler.openMainMenu();
  }
}
