package musicApp.server.serverData.AlbumPictures;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.musicPlayer.MusicPlayerViewModel;
import musicApp.server.model.Song;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

/**
 * Created by Alfacoaie on 02-Feb-21.
 */
public class SongController implements ViewController {
    @FXML
    private ImageView img;

    @FXML
    private Label songName;

    @FXML
    private Label artist;
    private ViewHandler vh;
    private MusicPlayerViewModel musicPlayerViewModel;

    public void setData(Song song) {
        songName.setText(song.getTitle());
        artist.setText(song.getArtist().getName());
        System.out.println(song.getAlbum().getPicturePath());
        URL url = getClass().getResource(song.getAlbum().getPicturePath());
        Image image1 = new Image(String.valueOf(url));
        img.setImage(image1);
    }

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.musicPlayerViewModel = vmf.getMusicPlayerViewModel();
    }
}
