package musicApp.client.network.musicplayer;

import musicApp.shared.networking.RMIServer;

import java.io.File;
import java.util.ArrayList;

public interface MusicPlayerClient {
    //----------MUSIC-------------
    ArrayList<File> getCurrentPlaylist();
    void setServer(RMIServer server);

    File fetchAlbumCover(String picturePath);
}
