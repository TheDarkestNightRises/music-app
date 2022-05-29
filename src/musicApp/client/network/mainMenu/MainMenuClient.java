package musicApp.client.network.mainMenu;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.RMIServer;

import java.util.ArrayList;

public interface MainMenuClient {
    ArrayList<Song> fetchRandomSongs();

    ArrayList<Song> fetchLastSongs();

    ArrayList<Album> fetchRandomAlbums();
}
