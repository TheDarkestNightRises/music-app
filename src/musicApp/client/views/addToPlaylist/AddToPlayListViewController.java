package musicApp.client.views.addToPlaylist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.Song;

/**
 * Controller for Add to playlist
 */
public class AddToPlayListViewController implements ViewController {
    @FXML
    private ListView<String> list;
    @FXML
    private Label error;
    private ViewHandler viewHandler;
    private AddToPlaylistViewModel viewModel;

    /**
     * initialises the view handler, the view model, the song to be added in a playlist, binds the controls
     * @param vh
     * @param vmf
     * @param args
     */
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

    /**
     * This method is linked to a button that on action will open the music player
     */
    @FXML
    public void backToMusicPlayer()
    {
        viewHandler.openMusicPlayer();
    }
    /**
     * This method is linked to a button that on action will delegate to the view model adding the playlist at the specified index
     */
    @FXML
    public void addButtonPressed()
    {
        viewModel.addToPlaylist(list.getSelectionModel().getSelectedIndex());
    }
}

