package musicApp.client.views.deleteSong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

public class DeleteSongViewController implements ViewController
{
  @FXML private ListView<String> list;
  @FXML private Label error;
  private ViewHandler viewHandler;
  private DeleteSongViewModel viewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf,
      Object... args)
  {
    viewHandler = vh;
    viewModel = vmf.getDeleteSongViewModel();
    viewModel.bindError(error.textProperty());
    viewModel.bindList(list.itemsProperty());
    viewModel.reset();
  }

  @FXML public void backToProfile()
  {
    viewHandler.openMainMenu();
  }

  @FXML protected void deleteButtonPressed()
  {

    if(viewModel.deleteSong(list.getSelectionModel().getSelectedIndex()))
    {
      viewModel.reset();
    }
  }
}

