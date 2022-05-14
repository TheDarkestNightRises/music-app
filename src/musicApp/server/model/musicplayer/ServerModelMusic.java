package musicApp.server.model.musicplayer;

import java.io.File;
import java.util.ArrayList;

public interface ServerModelMusic {
    //-------MusicPlayer--------
    ArrayList<File> getCurrentPlaylist();

    File fetchAlbumCover(String picturePath);
}
