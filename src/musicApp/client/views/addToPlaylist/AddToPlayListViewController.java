package musicApp.client.views.addToPlaylist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.Song;

public class AddToPlayListViewController implements ViewController {
    @FXML
    private ListView<String> list;
    @FXML
    private Label error;
    private ViewHandler viewHandler;
    private AddToPlaylistViewModel viewModel;
    

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
        viewHandler = vh;
        viewModel = vmf.getAddToPlaylistViewModel();
        viewModel.bindList(list.itemsProperty());
        viewModel.bindError(error.textProperty());
        Song song  = (Song) args[0];
        viewModel.reset();
        viewModel.setSong(song);
    }

    @FXML
    public void backToMusicPlayer()
    {
        viewHandler.openMusicPlayer();
    }
    @FXML
    public void addButtonPressed()
    {
        viewModel.addToPlaylist(list.getSelectionModel().getSelectedIndex());
    }
}

