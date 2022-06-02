package musicApp.client.views.navigationBar;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

/**
 * The navigation view is a sidebar subview in most windows
 * to be able to navigate the application easily. The controller for the navigation view is responsible
 * for opening the views and checking if the user is an artist to give access to additional buttons
 */
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

    /**
     * This is the constructor of the navigation bar
     * @param vh viewHandler to open windows
     * @param vmf to initialize viewModel
     * @param args -
     */
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

    /**
     * This is method is linked to the openChat button. On action it will open the chat
     * window
     */
    @FXML
    public void openChat() {
        viewHandler.openChat();
    }

    /**
     * This is method is linked to the openMainMenu button. On action it will open the main menu
     * window
     */
    @FXML
    public void openMain() {
        viewHandler.openMainMenu();
    }

    /**
     * This is method is linked to the settings button. On action it will open the settings window
     */
    @FXML
    public void openSettings() {
        viewHandler.openUpdateSettings(navigationViewModel.fetchUser());
    }

    /**
     * This is method is linked to the createPlaylist button.
     * On action it will open the createPlaylist window
     */
    @FXML
    public void openCreatePlaylist() {
        viewHandler.openCreatePlaylist();
    }

    /**
     * This is method is linked to the search button.
     * On action it will open the search window
     */
    @FXML
    public void openSearch() {
        viewHandler.openSearch();
    }

    /**
     * This is method is linked to the openAddAlbum button.
     * On action it will open the AddAlbum window
     */
    @FXML
    public void openAddAlbum() {
        viewHandler.openAddAlbum();
    }

    /**
     * This is method is linked to the RemoveAlbum button.
     * On action it will open the RemoveAlbum window
     */
    @FXML
    public void openRemoveAlbum() {
        viewHandler.openRemoveAlbum();
    }

    /**
     * This is method is linked to the AddSong button.
     * On action it will open the AddSong window
     */
    @FXML
    public void openAddSong() {
        viewHandler.openAddSong();
    }

    /**
     * This is method is linked to the RemoveSong button.
     * On action it will open the RemoveSong window
     */
    @FXML
    public void openRemoveSong() {
        viewHandler.openDeleteSong();
    }

    private boolean isArtist() {
        return navigationViewModel.isArtist();
    }

    @FXML
    public void openRemovePlaylist(){viewHandler.openRemovePlaylist();}
}
