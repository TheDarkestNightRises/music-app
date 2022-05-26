package musicApp.client.views.deleteSong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.User;

public class DeleteSongViewController implements ViewController
{
  @FXML private ListView<String> list;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private DeleteSongViewModel viewModel;
  private User user;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf,
      Object... args)
  {
    viewHandler = vh;
    viewModel = vmf.getDeleteSongViewModel();
    user = (User) args[0];
    viewModel.bindError(errorLabel.textProperty());
    viewModel.bindList(list.itemsProperty());
    viewModel.reset();
  }

  @FXML public void backToProfile()
  {
    viewHandler.openProfile(user);
  }

  @FXML protected void deleteButtonPressed()
  {

  }
}

