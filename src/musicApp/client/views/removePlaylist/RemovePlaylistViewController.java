package musicApp.client.views.removePlaylist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;


/**
 *This is the controller for removing a playlist view
 */
public class RemovePlaylistViewController implements ViewController
{
  @FXML
  private ListView<String> list;
  @FXML
  private Label error;
  private ViewHandler viewHandler;
  private RemovePlaylistViewModel viewModel;


  /**
   *  The constructor of this controller. It calls the view model to do bindings
   * @param vh
   * @param vmf
   * @param args
   */
  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Object... args)
  {
    viewHandler = vh;
    viewModel = vmf.getRemovePlaylistViewModel();
    viewModel.bindList(list.itemsProperty());
    viewModel.bindError(error.textProperty());
    viewModel.reset();
  }

  /**
   * This method opens the main menu
   */
  @FXML
  public void backButtonPressed()
  {
    viewHandler.openMainMenu();
  }


  /**
   * This method will remove the current selected album
   */
  @FXML
  public void removeButtonPressed()
  {
    viewModel.removePlaylist(list.getSelectionModel().getSelectedIndex());
  }
}
