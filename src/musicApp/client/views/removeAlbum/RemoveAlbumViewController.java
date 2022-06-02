package musicApp.client.views.removeAlbum;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

public class RemoveAlbumViewController implements ViewController
{
  @FXML
  private ListView<String> list;
  @FXML
  private Label error;
  private ViewHandler viewHandler;
  private RemoveAlbumViewModel viewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Object... args)
  {
    viewHandler = vh;
    viewModel = vmf.getRemoveAlbumViewModel();
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
    viewModel.removeAlbum(list.getSelectionModel().getSelectedIndex());
  }
}
