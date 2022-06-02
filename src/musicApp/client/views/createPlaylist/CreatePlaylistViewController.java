package musicApp.client.views.createPlaylist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

/**
 * Controller for Create Playlist
 */
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

  /**
   * initialises the viewhandler, teh view model, and binds the controls
   * @param vh
   * @param vmf
   * @param args
   */
  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
    viewHandler = vh;
    viewModel = vmf.getCreatePlaylistViewModel();
    viewModel.bindTitle(title.textProperty());
    viewModel.bindDescription(description.textProperty());
    viewModel.bindError(error.textProperty());
    System.out.println("binded");
  }

  /**
   * onActionMethod of a field that focuses the description
   */
  @FXML
  public void submitTitle() {
    description.requestFocus();
  }

  /**
   * onAction method of a button that opens the Main Menu
   */
  @FXML
  public void back()
  {
    viewHandler.openMainMenu();
  }

  /**
   * onAction method of a button thatdelegates creation of playlist to the view model and returns to main menu
   */
  @FXML
  protected void createButtonPressed() {
    viewModel.createPlaylist();
    viewHandler.openMainMenu();
  }
}
