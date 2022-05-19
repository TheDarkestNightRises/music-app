package musicApp.server.model.mainMenu;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public interface ServerModelMainMenu {
    ArrayList<Song> fetchRandomSongs();

    ArrayList<Song> fetchLastSongs();

    ArrayList<Album> fetchRandomAlbums();
}
