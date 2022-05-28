package musicApp.client.views.artistProfile;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.customControls.AlbumsHBoxControl;
import musicApp.client.views.customControls.LoadingTextControl;
import musicApp.client.views.customControls.PlaylistTitleControl;
import musicApp.client.views.customControls.SongsHBoxControl;
import musicApp.client.views.profile.ProfileViewModel;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.beans.PropertyChangeEvent;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class ArtistProfileViewController implements ViewController {
    @FXML
    public VBox profileContainer;
    @FXML
    public ImageView profilePicture;
    @FXML
    public Text profileName;
    @FXML
    public Text profileDescription;
    @FXML
    public VBox followListSubView;
    @FXML
    public HBox profileCardContainer;
    @FXML
    public Button follow;
    @FXML
    public Button unfollow;
    @FXML
    public VBox navigationSubView;

    private User user;
    private ViewHandler vh;
    private ArtistProfileViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.viewModel = vmf.getArtistProfileViewModel();
        user = (User) args[0];
        initArtistAlbums(user);
        ArrayList<Playlist> playlists = viewModel.fetchPlaylistsForUser(user);
        System.out.println(playlists);
        if (playlists == null) return;
        initPlaylistsView(playlists);
        initProfileInfo(user);
        openFollowList();
        openProfileCard();
        openNavigation();
        User user1 = viewModel.fetchUser();
        if (user.getUsername().equals(user1.getUsername())) {
            follow.setVisible(false);
            unfollow.setVisible(false);
        }
        viewModel.addListener("newPlaylist", this::onNewPlaylist);
    }



    private void onNewPlaylist(PropertyChangeEvent event) {
        ArrayList<Playlist> playlists = new ArrayList<>();
        playlists.add((Playlist) event.getNewValue());
        initPlaylistsView(playlists);
    }

    private void initProfileInfo(User user) {
        profileName.setText(user.getUsername() + " (ARTIST) ");
        Image image = new Image(new ByteArrayInputStream(fetchProfilePicture(user.getProfile_picture())));
        profilePicture.setImage(image);
        profileDescription.setText(user.getDescription());
    }

    private void openFollowList() {
        Parent followListRoot = vh.openFollowListSubView();
        followListSubView.getChildren().clear();
        followListSubView.getChildren().add(followListRoot);
    }

    private void openProfileCard() {
        Parent profileCardRoot = vh.openProfileCard();
        profileCardContainer.getChildren().clear();
        profileCardContainer.getChildren().add(profileCardRoot);
    }

    private void initArtistAlbums(User user) {
        new Thread(() -> {
            ArrayList<Album> albums = viewModel.fetchArtistAlbums(user);
            Platform.runLater(() -> {
                AlbumsHBoxControl albumsHBoxControl = new AlbumsHBoxControl(albums, vh, profileContainer);
            });
        }).start();
    }


    @FXML

    public void initPlaylistsView(ArrayList<Playlist> playlists) {
        for (Playlist playlist : playlists) {
            LoadingTextControl loadingTextControl = new LoadingTextControl();
            HBox containerHBox = new HBox();
            containerHBox.setAlignment(Pos.CENTER_LEFT);
            containerHBox.setPadding(new Insets(15));
            containerHBox.setSpacing(15);
            containerHBox.getChildren().add(loadingTextControl.getTextFromControl());
            profileContainer.getChildren().add(containerHBox);
            VBox vBoxContainer = new VBox();
            profileContainer.getChildren().add(vBoxContainer);
            new Thread(() -> {
                ArrayList<Song> songs = viewModel.fetchSongsForPlaylist(playlist);
                Platform.runLater(() -> {
                    containerHBox.getChildren().remove(0);
                    PlaylistTitleControl playlistTitleControl = new PlaylistTitleControl(vh, songs, playlist);
                    containerHBox.getChildren().add(playlistTitleControl);
                    SongsHBoxControl songsHBoxControl = new SongsHBoxControl(songs, playlist, vh, vBoxContainer);
                    viewModel.addListener("newSongAddedToPlaylist", songsHBoxControl::onNewSong);
                    //                    viewModel.addListener("newSongAddedToPlaylist", playlistTitleControl::onNewSong);
                    viewModel.addListener("newSongRemovedFromPlaylist", songsHBoxControl::onRemovedSong);
                    //                    viewModel.addListener("newSongRemovedFromPlaylist", playlistTitleControl::onRemovedSong);
                });
            }).start();
        }
    }

    public byte[] fetchProfilePicture(String picturePath) {
        return viewModel.fetchProfilePicture(picturePath);
    }

    public void follow() {
        viewModel.follow(user);
    }

    public void unfollow() {
        viewModel.unfollow(user);
    }

    private void openNavigation() {
        Parent navigationRoot = vh.openNavigation();
        navigationSubView.getChildren().clear();
        navigationSubView.getChildren().add(navigationRoot);
    }
}


