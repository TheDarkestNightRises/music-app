package musicApp.client.views.profile;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;


import java.io.IOException;
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
        ArrayList<Playlist> playlists = null;
        for (Object object : args) {
            playlists = viewModel.fetchPlaylistsForUser((User) object);
        }
        System.out.println(playlists);
        if (playlists == null) return;
        initPlaylists(playlists);
    }

    public void initPlaylists(ArrayList<Playlist> playlists){
        for (Playlist playlist : playlists) {
            Text playlistTitleText = vh.generateLoadingText();
            profileContainer.getChildren().add(playlistTitleText);
            VBox vBoxContainer = new VBox();
            profileContainer.getChildren().add(vBoxContainer);
            new Thread(()->{
                ArrayList<Song> songs = viewModel.fetchSongsForPlaylist(playlist);
                System.out.println(songs);
                Platform.runLater(()->{
                    vBoxContainer.getChildren().add(vh.generateView(songs));
                    playlistTitleText.setText(playlist.getTitle());
                });
            }).start();
        }
    }
}
