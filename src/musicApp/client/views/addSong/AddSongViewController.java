package musicApp.client.views.addSong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.deleteSong.DeleteSongViewModel;
import musicApp.server.model.domainModel.User;

public class AddSongViewController implements ViewController
{
  @FXML private ListView<String> list;
  @FXML private TextField title;
  @FXML private Label errorLabel;
  private ViewHandler viewHandler;
  private AddSongViewModel viewModel;
  private User user;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf,
      Object... args)
  {
    viewHandler = vh;
    viewModel = vmf.getAddSongViewModel();
    user = (User) args[0];
    viewModel.bindError(errorLabel.textProperty());
    viewModel.bindList(list.itemsProperty());
    viewModel.bindTitle(title.textProperty());
    viewModel.reset();
  }

  @FXML public void backToProfile()
  {
    viewHandler.openProfile(user);
  }

  @FXML protected void createButtonPressed()
  {

  }
}

