package musicApp.client.views.profile;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.musicPlayer.MusicPlayerViewModel;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class SinglesController  implements ViewController{
    @FXML
    private ImageView img;

    @FXML
    private Label songName;

    @FXML
    private Label artist;

    private ViewHandler viewHandler;
    private MusicPlayerViewModel musicPlayerViewModel;

    private Song song;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.musicPlayerViewModel = vmf.getMusicPlayerViewModel();
        this.song = (Song) args[0];
    }

    public void openSingle() {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song);
        viewHandler.openMusicPlayer(new Playlist(songs));
    }

    public void setData(Song song) {
        songName.setText(song.getTitle());
        artist.setText(song.getArtist().getName());
        Image image = new Image(new ByteArrayInputStream(musicPlayerViewModel.fetchAlbumCover(song.getAlbum().getPicturePath())));
        img.setImage(image);
    }
}
