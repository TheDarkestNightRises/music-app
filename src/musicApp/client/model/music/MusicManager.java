package musicApp.client.model.music;

import musicApp.server.model.domainModel.Playlist;

import java.io.File;
import java.util.ArrayList;

public interface MusicManager {
    ArrayList<File> getCurrentPlaylistFiles(Playlist playlist);

    byte[] fetchAlbumCover(String picturePath);
}
