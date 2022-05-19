package musicApp.client.model.mainMenu;

import musicApp.client.network.Client;
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
}
