package musicApp.client.model.music;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public interface MusicManager {
    ArrayList<File> getCurrentPlaylist();

    FileInputStream fetchAlbumCover(String picturePath);
}
