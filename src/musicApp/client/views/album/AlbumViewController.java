package musicApp.client.views.album;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;

import java.io.ByteArrayInputStream;

public class AlbumViewController implements ViewController {
    @FXML
    private ImageView albumCover;

    @FXML
    private Label albumName;

    @FXML
    private Label artist;

    private ViewHandler viewHandler;
    private AlbumViewModel albumViewModel;

    private Album album;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.albumViewModel = vmf.getAlbumViewModel();
        this.album = (Album) args[0];
        albumViewModel.bindAlbumName(albumName.textProperty());
        albumViewModel.bindArtist(artist.textProperty());
        albumViewModel.bindImage(albumCover.imageProperty());
        albumViewModel.init(album);
    }

    public void openMediaPlayer() {
        viewHandler.openMusicPlayer(new Playlist(album.getSongs()));
    }
}
