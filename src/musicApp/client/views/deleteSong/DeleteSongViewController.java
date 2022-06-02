package musicApp.client.views.deleteSong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

/**
 * Controller for delete song
 */
public class DeleteSongViewController implements ViewController
{
  @FXML private ListView<String> list;
  @FXML private Label error;
  private ViewHandler viewHandler;
  private DeleteSongViewModel viewModel;

  /**
   * initialises the viewhandler, the view model and binds the controls
   * @param vh
   * @param vmf
   * @param args
   */
  @Override public void init(ViewHandler vh, ViewModelFactory vmf,
      Object... args)
  {
    viewHandler = vh;
    viewModel = vmf.getDeleteSongViewModel();
    viewModel.bindError(error.textProperty());
    viewModel.bindList(list.itemsProperty());
    viewModel.reset();
  }

  /**
   * onAction method of a button that opens the Main Menu
   */
  @FXML public void backToProfile()
  {
    viewHandler.openMainMenu();
  }
/**
 * onAction method of a button that delegates the deletion of the selected song to the view model
 * the view resets if the deletion is successful
 */
  @FXML protected void deleteButtonPressed()
  {

    if(viewModel.deleteSong(list.getSelectionModel().getSelectedIndex()))
    {
      viewModel.reset();
    }
  }
}

