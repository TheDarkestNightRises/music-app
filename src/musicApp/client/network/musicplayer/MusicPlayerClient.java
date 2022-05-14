package musicApp.client.network.musicplayer;

import javafx.scene.image.Image;
import musicApp.shared.networking.RMIServer;

import java.io.File;
import java.util.ArrayList;

public interface MusicPlayerClient {
    //----------MUSIC-------------
    ArrayList<File> getCurrentPlaylist();
    void setServer(RMIServer server);

    Image fetchAlbumCover(String picturePath);
}
