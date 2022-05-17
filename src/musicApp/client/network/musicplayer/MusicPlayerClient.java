package musicApp.client.network.musicplayer;

import musicApp.server.model.domainModel.Playlist;
import musicApp.shared.networking.RMIServer;

import java.io.File;
import java.util.ArrayList;

public interface MusicPlayerClient {
    //----------MUSIC-------------
    ArrayList<File> getCurrentPlaylistFiles(Playlist playlist);
    void setServer(RMIServer server);

    byte[] fetchAlbumCover(String picturePath);
}
