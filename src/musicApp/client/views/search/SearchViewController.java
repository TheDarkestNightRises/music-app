package musicApp.client.views.search;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
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
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.search.SearchResultAlbum;
import musicApp.server.model.search.SearchResultSong;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

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
    public HBox createAlbum;
    @FXML
    public HBox removeAlbum;
    @FXML
    public HBox createSong;
    @FXML
    public HBox removeSong;
    private SearchViewModel searchViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.searchViewModel = vmf.getSearchViewModel();
        searchViewModel.init();
        comboBox.setItems(searchViewModel.getComboBoxChoices());
        searchViewModel.bindSearch(searchTextField.textProperty());
        searchViewModel.addListener("newSearchSong", this::showSongSearchResults);
        searchViewModel.addListener("newSearchAlbum", this::showAlbumSearchResults);
        searchViewModel.addListener("newSearchProfile", this::showProfileSearchResults);
        openFollowList();
        openProfileCard();
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

    private boolean isArtist()
    {
        return  searchViewModel.isArtist();
    }

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


    private void openProfileCard() {
        Parent profileCardRoot = viewHandler.openProfileCard();
        profileCardContainer.getChildren().clear();
        profileCardContainer.getChildren().add(profileCardRoot);
    }

    public void search() {
        searchViewModel.search(comboBox.getSelectionModel().getSelectedItem());
    }

    public void openChat() {
        viewHandler.openChat();
    }

    public void openSearch() {
        viewHandler.openSearch();
    }

    public void openCreatePlaylist()
    {
        viewHandler.openCreatePlaylist();
    }

    public void openAddAlbum() {viewHandler.openAddAlbum();}
    public void openRemoveAlbum(){viewHandler.openRemoveAlbum();}
    public void openAddSong()
    {
        viewHandler.openAddSong();
    }
    public void openRemoveSong()
    {
        viewHandler.openDeleteSong();
    }
    public void openRemovePlaylist(){viewHandler.openRemovePlaylist();}



    private void openFollowList() {
        Parent followListRoot = viewHandler.openFollowListSubView();
        followListSubView.getChildren().clear();
        followListSubView.getChildren().add(followListRoot);
    }

    public void openMain() {
        viewHandler.openMainMenu();
    }

    public void openSettings() {
        viewHandler.openUpdateSettings(searchViewModel.fetchUser());
    }
}
