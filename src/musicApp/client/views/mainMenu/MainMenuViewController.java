package musicApp.client.views.mainMenu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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

/**
 * This is the main menu controller. It's responsible for initializing the menu UI
 */
public class MainMenuViewController implements ViewController {
    @FXML
    public VBox mainMenuContainer;
    @FXML
    public VBox newHitsContainer;
    @FXML
    public VBox selectionContainer;
    @FXML
    public HBox profileCardContainer;
    @FXML
    public VBox followListSubView;
    @FXML
    public VBox navigationSubView;

    private ViewHandler viewHandler;
    private MainMenuViewModel viewModelMainMenu;

    /**
     * This is the constructor of the view model
     * @param vh to open windows
     * @param vmf to initialize viewModel
     * @param args -
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.viewModelMainMenu = vmf.getMainMenuViewModel();
        initLastSongs();
        initAlbums();
        initRandomSongs();
        openFollowList();
        openProfileCard();
        openNavigation();
    }

    /**
     * Method that gets random albums from server model and then puts them in an albumsHBox
     * custom control. It uses threads because the interface loading is quite heavy.Should use bindings
     */
    private void initAlbums() {
        new Thread(() -> {
            ArrayList<Album> albums = viewModelMainMenu.fetchRandomAlbums();
            Platform.runLater(() -> {
                AlbumsHBoxControl albumsHBoxControl = new AlbumsHBoxControl(albums, viewHandler, selectionContainer);
            });
        }).start();
    }

    /**
     * Method that gets random songs from server model and then puts them in an albumsHBox
     * custom control. It uses threads because the interface loading is quite heavy.Should use bindings
     */
    private void initRandomSongs() {
        new Thread(() -> {
            ArrayList<Song> songs = viewModelMainMenu.fetchRandomSongs();
            Platform.runLater(() -> {
                SinglesHBoxControl singlesHBoxControl = new SinglesHBoxControl(songs, viewHandler, selectionContainer);
            });
        }).start();
    }

    /**
     * Method that gets the latest songs from server model and then puts them in an albumsHBox
     * custom control. It uses threads because the interface loading is quite heavy.Should use bindings
     */
    private void initLastSongs() {
        new Thread(() -> {
            ArrayList<Song> songs = viewModelMainMenu.fetchLastSongs();
            Platform.runLater(() -> {
                SinglesHBoxControl singlesHBoxControl = new SinglesHBoxControl(songs, viewHandler, newHitsContainer);
                viewModelMainMenu.addListener("songAdded", singlesHBoxControl::addNewSong);
            });
        }).start();
    }

    /***
     * Followlist subview
     */
    private void openFollowList() {
        Parent followListRoot = viewHandler.openFollowListSubView();
        followListSubView.getChildren().clear();
        followListSubView.getChildren().add(followListRoot);
    }

    /***
     * ProfileCard subview
     */
    private void openProfileCard() {
        Parent profileCardRoot = viewHandler.openProfileCard();
        profileCardContainer.getChildren().clear();
        profileCardContainer.getChildren().add(profileCardRoot);
    }

    /***
     * Navigation subview
     */
    private void openNavigation() {
        Parent navigationRoot = viewHandler.openNavigation();
        navigationSubView.getChildren().clear();
        navigationSubView.getChildren().add(navigationRoot);
    }
}
