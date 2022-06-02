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
    public Button follow;
    @FXML
    public Button unfollow;
    @FXML
    public VBox navigationSubView;
    private User user;
    private ViewHandler vh;
    private ProfileViewModel viewModel;

    /**
     * This is the constructor for this controller
     * @param vh to open windows
     * @param vmf to init view model
     * @param args to init the user for the profile
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.viewModel = vmf.getProfileViewModel();
        user = (User) args[0];
        viewModel.bindDescription(profileDescription.textProperty());
        viewModel.bindImage(profilePicture.imageProperty());
        viewModel.bindName(profileName.textProperty());
        ArrayList<Playlist> playlists = viewModel.fetchPlaylistsForUser(user);
        if (playlists == null) return;
        initPlaylistsView(playlists);
        viewModel.init(user);
        openFollowList();
        openProfileCard();
        openNavigation();
        checkFollowButtonVisibility();
        viewModel.addListener("newPlaylist", this::onNewPlaylist);
    }

    /**
     *
     * @param event
     */
    private void onNewPlaylist(PropertyChangeEvent event) {
        ArrayList<Playlist> playlists = new ArrayList<>();
        playlists.add((Playlist) event.getNewValue());
        initPlaylistsView(playlists);
    }

    /**
     * followlist subview
     */
    private void openFollowList() {
        Parent followListRoot = vh.openFollowListSubView();
        followListSubView.getChildren().clear();
        followListSubView.getChildren().add(followListRoot);
    }

    /**
     * profilecard subview
     */
    private void openProfileCard() {
        Parent profileCardRoot = vh.openProfileCard();
        profileCardContainer.getChildren().clear();
        profileCardContainer.getChildren().add(profileCardRoot);
    }

    /**
     * navigation subview.
     */
    private void openNavigation() {
        Parent navigationRoot = vh.openNavigation();
        navigationSubView.getChildren().clear();
        navigationSubView.getChildren().add(navigationRoot);
    }

    /**
     * A way of generating and displaying playlists for users using custom controls.
     * DISCLAIMER : no bindings tight coupling, threads for optimization
     * @param playlists that the user has
     */
    public void initPlaylistsView(ArrayList<Playlist> playlists) {
        for (Playlist playlist : playlists) {
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

    /**
     * Fetch profile picture from server data
     * @param picturePath path to it
     * @return byte to the photo
     */
    public byte[] fetchProfilePicture(String picturePath) {
        return viewModel.fetchProfilePicture(picturePath);
    }

    public void follow(){
        viewModel.follow(user);
    };

    public void unfollow(){ viewModel.unfollow(user);}

    private void checkFollowButtonVisibility() {
        User currentUser = viewModel.fetchUser();
        if(user.getUsername().equals(currentUser.getUsername()))
        {
            follow.setVisible(false);
            unfollow.setVisible(false);
        }
    }


}
