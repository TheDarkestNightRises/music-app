package musicApp.client.views.profile;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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

    private ViewHandler vh;
    private ProfileViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.viewModel = vmf.getProfileViewModel();
        User user = (User) args[0];
        ArrayList<Playlist> playlists = viewModel.fetchPlaylistsForUser(user);
        System.out.println(playlists);
        if (playlists == null) return;
        initPlaylistsView(playlists);
        initProfileInfo(user);
        openFollowList();
    }

    private void initProfileInfo(User user) {
        profileName.setText(user.getUsername());
        Image image = new Image(new ByteArrayInputStream(fetchProfilePicture(user.getProfile_picture())));
        profilePicture.setImage(image);
        profileDescription.setText(user.getDescription());
    }

    private void openFollowList() {
//        Parent followListRoot = vh.openFollowListSubView();
//        followListSubView.getChildren().clear();
//        followListSubView.getChildren().add(followListRoot);
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
                    containerHBox.getChildren().add(new PlaylistTitleControl(vh, songs, playlist));
                    SongsHBoxControl songsHBoxControl = new SongsHBoxControl(songs, vh, vBoxContainer);
                });
            }).start();
        }
    }

    public byte[] fetchProfilePicture(String picturePath) {
        return viewModel.fetchProfilePicture(picturePath);
    }

    public void openSearch() {
        vh.openSearch();
    }
}
