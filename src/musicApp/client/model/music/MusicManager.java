package musicApp.client.model.music;

import java.io.File;
import java.util.ArrayList;

public interface MusicManager {
    ArrayList<File> getCurrentPlaylist();

    File fetchAlbumCover(String picturePath);
}
