package musicApp.client.views.profile;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.database.song.Song;

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

    public void setData(Song song){
        Image image = new Image(getClass().getResourceAsStream(song.getFile_path()));
        img.setImage(image);
        songName.setText(song.getTitle());
        artist.setText(song.getTitle());
    }

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {

    }
}
