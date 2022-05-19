package musicApp.client.model.mainMenu;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class MainMenuManagerImplementation implements MainMenuManager{

    private final Client client;
    private final PropertyChangeSupport support;

    public MainMenuManagerImplementation(Client client) {
        this.client = client;
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public ArrayList<Song> fetchRandomSongs() {
        return client.getMainMenuClient().fetchRandomSongs();
    }

    @Override
    public ArrayList<Song> fetchLastSongs() {
        return client.getMainMenuClient().fetchLastSongs();
    }

    @Override
    public ArrayList<Album> fetchRandomAlbums() {
        return client.getMainMenuClient().fetchRandomAlbums();
    }
}
