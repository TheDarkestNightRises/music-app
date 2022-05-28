package musicApp.client.views.navigationBar;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

public class NavigationViewController implements ViewController {

    @FXML
    public HBox createAlbum;
    @FXML
    public HBox removeAlbum;
    @FXML
    public HBox createSong;
    @FXML
    public HBox removeSong;

    private ViewHandler viewHandler;
    private NavigationViewModel navigationViewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.navigationViewModel = vmf.getNavigationViewModel();
        if(isArtist())
        {
            createAlbum.setVisible(true);
            removeAlbum.setVisible(true);
            createSong.setVisible(true);
            removeSong.setVisible(true);
        }
        else
        {
            createAlbum.setVisible(false);
            removeAlbum.setVisible(false);
            createSong.setVisible(false);
            removeSong.setVisible(false);
        }
    }
    public void openChat() {
        viewHandler.openChat();
    }

    public void openMain() {
        viewHandler.openMainMenu();
    }

    public void openSettings() {
        viewHandler.openUpdateSettings(navigationViewModel.fetchUser());
    }

    public void openCreatePlaylist() {
        viewHandler.openCreatePlaylist();
    }

    public void openSearch() {
        viewHandler.openSearch();
    }

    public void openAddAlbum() {
        viewHandler.openAddAlbum();
    }

    public void openRemoveAlbum() {
        viewHandler.openRemoveAlbum();
    }

    public void openAddSong() {
        viewHandler.openAddSong();
    }

    public void openRemoveSong() {
        viewHandler.openDeleteSong();
    }

    private boolean isArtist() {
        return navigationViewModel.isArtist();
    }
}
