package musicApp.client.views.mainMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class MainMenuViewController implements ViewController {
    @FXML
    public VBox mainMenuContainer;
    private ViewHandler viewHandler;
    private MainMenuViewModel viewModelMainMenu;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.viewModelMainMenu = vmf.getMainMenuViewModel();
        initLastSongs();
        initRandomSongs();
        initAlbums();
    }

    private void initAlbums() {
    }

    private void initRandomSongs() {
        ArrayList<Song> songs = viewModelMainMenu.fetchRandomSongs();
        System.out.println(songs);
    }

    private void initLastSongs() {
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
