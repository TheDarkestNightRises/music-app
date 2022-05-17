package musicApp.server.model.musicplayer;

import musicApp.server.model.domainModel.Playlist;

import java.io.File;
import java.util.ArrayList;

public interface ServerModelMusic {
    //-------MusicPlayer--------
    ArrayList<File> getCurrentPlaylistFiles(Playlist playlist);

    byte[] fetchAlbumCover(String picturePath);
}
