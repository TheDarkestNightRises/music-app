package musicApp.client.views.profile;

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
import musicApp.client.views.customControls.*;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;


import java.beans.PropertyChangeEvent;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class ProfileViewController implements ViewController {
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
    public HBox createAlbum;
    @FXML
    public HBox removeAlbum;
    @FXML
    public HBox createSong;
    @FXML
    public HBox removeSong;
    @FXML
    public Button follow;
    @FXML
    public Button unfollow;
    private User user;
    private ViewHandler vh;
    private ProfileViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.viewModel = vmf.getProfileViewModel();
        user = (User) args[0];
        ArrayList<Playlist> playlists = viewModel.fetchPlaylistsForUser(user);
        System.out.println(playlists);
        if (playlists == null) return;
        initPlaylistsView(playlists);
        initProfileInfo(user);
        openFollowList();
        openProfileCard();
        viewModel.addListener("newPlaylist", this::onNewPlaylist);
        User user1 = viewModel.fetchUser();
        if(user.getUsername().equals(user1.getUsername()))
        {
            follow.setVisible(false);
            unfollow.setVisible(false);
        }

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
        return viewModel.isArtist();
    }

    private void onNewPlaylist(PropertyChangeEvent event) {
        ArrayList<Playlist> playlists = new ArrayList<>();
        playlists.add((Playlist) event.getNewValue());
        initPlaylistsView(playlists);
    }

    private void initProfileInfo(User user) {
        profileName.setText(user.getUsername());
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

    @FXML
    public void openChat() {
        vh.openChat();
    }

    public void initPlaylistsView(ArrayList<Playlist> playlists) {
        for (Playlist playlist : playlists) {
//            Text playlistTitleText = vh.generateLoadingText();
//            HBox containerHBox = new HBox();
//            containerHBox.setAlignment(Pos.CENTER_LEFT);
//            containerHBox.setPadding(new Insets(10));
//            containerHBox.setSpacing(10);
//            containerHBox.getChildren().add(playlistTitleText);
//            profileContainer.getChildren().add(containerHBox);
//            VBox vBoxContainer = new VBox();
//            profileContainer.getChildren().add(vBoxContainer);
//            new Thread(() -> {
//                ArrayList<Song> songs = viewModel.fetchSongsForPlaylist(playlist);
//                System.out.println(songs);
//                Platform.runLater(() -> {
//                    vBoxContainer.getChildren().add(vh.generateView(songs));
//                    playlistTitleText.setText(playlist.getTitle());
//                    containerHBox.getChildren().add(vh.generateTitleHBox(songs));
//                });
//            }).start();

            LoadingTextControl loadingTextControl = new LoadingTextControl();
            HBox containerHBox = new HBox();
            containerHBox.setAlignment(Pos.CENTER_LEFT);
            containerHBox.setPadding(new Insets(10));
            containerHBox.setSpacing(10);
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
                    SongsHBoxControl songsHBoxControl = new SongsHBoxControl(songs,playlist, vh, vBoxContainer);
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

    public void follow(){
        viewModel.follow(user);
    };

    public void unfollow(){ viewModel.unfollow(user);}


}
