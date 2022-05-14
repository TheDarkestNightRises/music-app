package musicApp.server.model.musicplayer;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;

public interface ServerModelMusic {
    //-------MusicPlayer--------
    ArrayList<File> getCurrentPlaylist();

    Image fetchAlbumCover(String picturePath);
}
