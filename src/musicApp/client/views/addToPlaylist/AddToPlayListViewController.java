package musicApp.client.views.addToPlaylist;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.Playlist;

public class AddToPlayListViewController implements ViewController {
    @FXML
    private ListView<String> list;

    private ViewHandler viewHandler;
    private AddToPlaylistViewModel viewModel;
    

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
        viewHandler = vh;
        viewModel = vmf.getAddToPlaylistViewModel();
        //viewModel.reset();
        viewModel.bindLogs(list.itemsProperty());
        viewModel.reset();
    }

    @FXML
    public void backToMusicPlayer()
    {

    }
    @FXML
    public void addButtonPressed()
    {
        viewModel.addToPlaylist(list.getSelectionModel().getSelectedIndex());
    }
}

