package musicApp.client.network.musicplayer;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.io.File;
import java.util.ArrayList;

public interface MusicPlayerClient {
    //----------MUSIC-------------
    ArrayList<File> getCurrentPlaylistFiles(Playlist playlist);

    byte[] fetchAlbumCover(String picturePath);

    void addToLikedSongs(User user, Song song);

    void removeToLikedSongs(User user, Song song);
}
