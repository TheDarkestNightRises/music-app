package musicApp.client.model.music;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;

public interface MusicManager {
    ArrayList<File> getCurrentPlaylist();

    Image fetchAlbumCover(String picturePath);
}
