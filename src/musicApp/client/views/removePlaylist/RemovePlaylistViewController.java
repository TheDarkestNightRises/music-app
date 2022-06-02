package musicApp.client.views.removePlaylist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

public class RemovePlaylistViewController implements ViewController
{
  @FXML
  private ListView<String> list;
  @FXML
  private Label error;
  private ViewHandler viewHandler;
  private RemovePlaylistViewModel viewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Object... args)
  {
    viewHandler = vh;
    viewModel = vmf.getRemovePlaylistViewModel();
    viewModel.bindList(list.itemsProperty());
    viewModel.bindError(error.textProperty());
    viewModel.reset();
  }

  @FXML
  public void backButtonPressed()
  {
    viewHandler.openMainMenu();
  }
  @FXML
  public void removeButtonPressed()
  {
    viewModel.removePlaylist(list.getSelectionModel().getSelectedIndex());
  }
}
