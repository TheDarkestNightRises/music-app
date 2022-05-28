package musicApp.client.views.single;

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

public class SingleController implements ViewController{
    @FXML
    private ImageView albumCover;

    @FXML
    private Label songName;

    @FXML
    private Label artist;

    private ViewHandler viewHandler;

    private SingleViewModel singleViewModel;

    private Song song;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.singleViewModel = vmf.getSingleViewModel();
        singleViewModel.bindSongName(songName.textProperty());
        singleViewModel.bindArtist(artist.textProperty());
        singleViewModel.bindImage(albumCover.imageProperty());
        this.song = (Song) args[0];
        singleViewModel.init(song);
    }

    public void openSingle() {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song);
        viewHandler.openMusicPlayer(new Playlist(songs));
    }
}
