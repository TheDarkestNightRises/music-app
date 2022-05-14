package musicApp.server.model.musicplayer;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public interface ServerModelMusic {
    //-------MusicPlayer--------
    ArrayList<File> getCurrentPlaylist();

    FileInputStream fetchAlbumCover(String picturePath);
}
