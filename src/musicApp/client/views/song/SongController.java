package musicApp.client.views.song;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.musicPlayer.MusicPlayerViewModel;
import musicApp.server.model.domainModel.Song;

import java.io.ByteArrayInputStream;


public class SongController implements ViewController {
    @FXML
    private ImageView albumCover;

    @FXML
    private Label songName;

    @FXML
    private Label artist;

    private ViewHandler vh;
    private SongViewModel songViewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.songViewModel = vmf.getSongViewModel();
        songViewModel.bindSongName(songName.textProperty());
        songViewModel.bindArtist(artist.textProperty());
        songViewModel.bindImage(albumCover.imageProperty());
        songViewModel.init((Song) args[0]);
    }
}
