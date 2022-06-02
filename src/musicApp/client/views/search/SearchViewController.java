package musicApp.client.views.search;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.customControls.AlbumsHBoxControl;
import musicApp.client.views.customControls.ProfileCardVboxControl;
import musicApp.client.views.customControls.SinglesHBoxControl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

/**
 * This is the controller for the search view.
 */
public class SearchViewController implements ViewController {

    @FXML
    public VBox followListSubView;
    @FXML
    public HBox profileCardContainer;
    @FXML
    public VBox searchContainer;
    @FXML
    public TextField searchTextField;
    @FXML
    public ComboBox<SearchComboBoxChoices> comboBox;
    @FXML
    public Label searchLabel;
    @FXML
    public VBox navigationSubView;

    private SearchViewModel searchViewModel;
    private ViewHandler viewHandler;

    /** The init function is the constructor of this. It calls the bindings from the viewModel
     * and initialize the viewModel and viewHandler. It will also initialize the combo box choices
     * and add any listeners to the viewModel
     * @param vh for opening windows
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.searchViewModel = vmf.getSearchViewModel();
        searchViewModel.init();
        comboBox.setItems(searchViewModel.getComboBoxChoices());
        searchViewModel.bindSearch(searchTextField.textProperty());
        searchViewModel.bindSearchText(searchLabel.textProperty());
        searchViewModel.addListener("newSearchSong", this::showSongSearchResults);
        searchViewModel.addListener("newSearchAlbum", this::showAlbumSearchResults);
        searchViewModel.addListener("newSearchProfile", this::showProfileSearchResults);
        openFollowList();
        openProfileCard();
        openNavigation();
    }


    /**
     * When the view model is updated with the search results (ASYNC CALL it fires the property only
     * when the search is ready)
     * the controller will update the UI using custom controls.
     * @param event from the view Model
     */
    private void showProfileSearchResults(PropertyChangeEvent event) {
        new Thread(() -> {
            ArrayList<User> users = (ArrayList<User>) event.getNewValue();
            Platform.runLater(() -> {
                searchContainer.getChildren().clear();
                ProfileCardVboxControl profileCardVboxControl = new ProfileCardVboxControl(users, viewHandler, searchContainer);
            });
        }).start();
    }

    private void showSongSearchResults(PropertyChangeEvent event) {
        new Thread(() -> {
            ArrayList<Song> songs = (ArrayList<Song>) event.getNewValue();
            Platform.runLater(() -> {
                searchContainer.getChildren().clear();
                SinglesHBoxControl songsHBoxControl = new SinglesHBoxControl(songs, viewHandler, searchContainer);
            });
        }).start();
    }

    private void showAlbumSearchResults(PropertyChangeEvent event) {
        new Thread(() -> {
            ArrayList<Album> albums = (ArrayList<Album>) event.getNewValue();
            Platform.runLater(() -> {
                searchContainer.getChildren().clear();
                AlbumsHBoxControl albumsHBoxControl = new AlbumsHBoxControl(albums, viewHandler, searchContainer);
            });
        }).start();
    }

    /**
     * Opening of the subview profile card
     */
    private void openProfileCard() {
        Parent profileCardRoot = viewHandler.openProfileCard();
        profileCardContainer.getChildren().clear();
        profileCardContainer.getChildren().add(profileCardRoot);
    }

    /**
     * This method is linked to a button that on action will search for a specific category
     */
    @FXML
    public void search() {
        searchViewModel.search(comboBox.getSelectionModel().getSelectedItem());
    }

    /**
     * Opening of the subview follow list
     */
    private void openFollowList() {
        Parent followListRoot = viewHandler.openFollowListSubView();
        followListSubView.getChildren().clear();
        followListSubView.getChildren().add(followListRoot);
    }

    /**
     * Opening of the navigation
     */
    private void openNavigation() {
        Parent navigationRoot = viewHandler.openNavigation();
        navigationSubView.getChildren().clear();
        navigationSubView.getChildren().add(navigationRoot);
    }
}
