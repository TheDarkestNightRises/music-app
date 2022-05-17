package musicApp.client.views.profile;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.customControls.LoadingTextControl;
import musicApp.client.views.customControls.PlaylistViewControl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;


import java.util.ArrayList;

public class ProfileViewController implements ViewController {
    @FXML
    public VBox profileContainer;

    private ViewHandler vh;
    private ProfileViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.viewModel = vmf.getProfileViewModel();
        ArrayList<Playlist> playlists = viewModel.fetchPlaylistsForUser((User) args[0]);
        System.out.println(playlists);
        if (playlists == null) return;
        initPlaylistsView(playlists);
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
//            new Thread(()->{
//                ArrayList<Song> songs = viewModel.fetchSongsForPlaylist(playlist);
//                System.out.println(songs);
//                Platform.runLater(()->{
//                    vBoxContainer.getChildren().add(vh.generateView(songs));
//                    playlistTitleText.setText(playlist.getTitle());
//                    containerHBox.getChildren().add(vh.generateTitleHBox(songs));
//                });
//            }).start();
            new Thread(() -> {
                ArrayList<Song> songs = viewModel.fetchSongsForPlaylist(playlist);
                Platform.runLater(() -> {
                    PlaylistViewControl playlistViewControl = new PlaylistViewControl(songs, vh, playlist, profileContainer);
                });
            }).start();
        }
    }
}
