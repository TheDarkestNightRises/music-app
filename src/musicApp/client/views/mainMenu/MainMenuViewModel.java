package musicApp.client.views.mainMenu;

import musicApp.client.model.MainModel;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainMenuViewModel implements Subject {
    private final MainModel mainModel;
    private PropertyChangeSupport support;

    public MainMenuViewModel(MainModel mainModel) {
        this.mainModel = mainModel;
        this.support = new PropertyChangeSupport(this);
    }

    public ArrayList<Song> fetchRandomSongs() {
        return mainModel.getMainMenuManager().fetchRandomSongs();
    }

    public ArrayList<Song> fetchLastSongs() {
       return mainModel.getMainMenuManager().fetchLastSongs();
    }

    public ArrayList<Album> fetchRandomAlbums() {
        return mainModel.getMainMenuManager().fetchRandomAlbums();
    }

    public User fetchUser() {
        return mainModel.getLogInManager().getUser();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }

    public boolean isArtist()
    {
        User user = mainModel.getLogInManager().getUser();
        return mainModel.getProfileManager().isArtist(user);
    }
}
