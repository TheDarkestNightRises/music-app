package musicApp.client.views.mainMenu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.customControls.AlbumsHBoxControl;
import musicApp.client.views.customControls.LoadingTextControl;
import musicApp.client.views.customControls.SinglesHBoxControl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class MainMenuViewController implements ViewController {
    @FXML
    public VBox mainMenuContainer;
    @FXML
    public VBox newHitsContainer;
    @FXML
    public VBox selectionContainer;

    private ViewHandler viewHandler;
    private MainMenuViewModel viewModelMainMenu;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.viewModelMainMenu = vmf.getMainMenuViewModel();
        initLastSongs();
        initAlbums();
        initRandomSongs();
    }

    private void initAlbums() {
        new Thread(() -> {
            ArrayList<Album> albums = viewModelMainMenu.fetchRandomAlbums();
            Platform.runLater(() -> {
                AlbumsHBoxControl albumsHBoxControl = new AlbumsHBoxControl(albums, viewHandler, selectionContainer);
            });
        }).start();
    }

    private void initRandomSongs() {
        new Thread(() -> {
            ArrayList<Song> songs = viewModelMainMenu.fetchRandomSongs();
            Platform.runLater(() -> {
                SinglesHBoxControl singlesHBoxControl = new SinglesHBoxControl(songs, viewHandler, selectionContainer);
            });
        }).start();
    }

    private void initLastSongs() {
        new Thread(() -> {
            ArrayList<Song> songs = viewModelMainMenu.fetchLastSongs();
            Platform.runLater(() -> {
                SinglesHBoxControl singlesHBoxControl = new SinglesHBoxControl(songs, viewHandler, newHitsContainer);
                viewModelMainMenu.addListener("songAdded", singlesHBoxControl::addNewSong);
            });
        }).start();
    }

    @FXML
    public void openSearch() {
        viewHandler.openSearch();
    }

    @FXML
    public void openChat() {
        viewHandler.openChat();
    }
}
