package musicApp.client.views.album;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.musicPlayer.MusicPlayerViewModel;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;

import java.io.ByteArrayInputStream;

public class AlbumViewController implements ViewController {
    @FXML
    private ImageView img;

    @FXML
    private Label albumName;

    @FXML
    private Label artist;

    private ViewHandler viewHandler;
    private MusicPlayerViewModel musicPlayerViewModel;

    private Album album;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.musicPlayerViewModel = vmf.getMusicPlayerViewModel();
        this.album = (Album) args[0];
    }

    public void setData(Album album) {
        albumName.setText(album.getTitle());
        artist.setText(album.getArtist().getName());
        System.out.println(album);
        Image image = new Image(new ByteArrayInputStream(musicPlayerViewModel.fetchAlbumCover(album.getPicturePath())));
        img.setImage(image);
    }

    public void openMediaPlayer() {
        viewHandler.openMusicPlayer(new Playlist(album.getSongs()));
    }
}
