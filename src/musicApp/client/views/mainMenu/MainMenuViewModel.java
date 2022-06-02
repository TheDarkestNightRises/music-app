package musicApp.client.views.mainMenu;

import musicApp.client.model.login.LogInManager;
import musicApp.client.model.mainMenu.MainMenuManager;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class MainMenuViewModel implements Subject {
    private MainMenuManager mainMenuManager;
    private LogInManager logInManager;
    private PropertyChangeSupport support;

    public MainMenuViewModel(MainMenuManager mainMenuManager, LogInManager loginManager) {
        this.mainMenuManager = mainMenuManager;
        this.logInManager = loginManager;
        this.support = new PropertyChangeSupport(this);
    }

    /**
     * This method delegates to the model to fetch random songs
     * @return random songs
     */
    public ArrayList<Song> fetchRandomSongs() {
        return mainMenuManager.fetchRandomSongs();
    }


    /**
     * This method delegates to the model to fetch last songs
     * @return last songs
     */
    public ArrayList<Song> fetchLastSongs() {
        return mainMenuManager.fetchLastSongs();
    }


    /**
     * This method delegates to the model to random albums
     * @return random albums
     */
    public ArrayList<Album> fetchRandomAlbums() {
        return mainMenuManager.fetchRandomAlbums();
    }

    public User fetchUser() {
        return logInManager.getUser();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
