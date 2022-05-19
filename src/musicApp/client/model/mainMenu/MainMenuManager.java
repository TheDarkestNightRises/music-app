package musicApp.client.model.mainMenu;

import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public interface MainMenuManager {
    ArrayList<Song> fetchRandomSongs();
}
