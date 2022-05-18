package musicApp.server.model.search;

import musicApp.database.song.SongDAO;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Song;
import musicApp.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelSearchImpl implements ServerModelSearch {
    private ArrayList<Song> songs;
    private ArrayList<Song> searchResultsSorted;
    private SongDAO songDAO;
    private PropertyChangeSupport support;

    public ServerModelSearchImpl() {
        try {
            this.songDAO = SongDAOImpl.getInstance();
            this.searchResultsSorted = new ArrayList<>();
            this.songs = songDAO.getAllSongs();
            this.support = new PropertyChangeSupport(this);
            System.out.println(songs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Song> fetchSortedList() {
        return songs;
    }

    @Override
    public void search(String newValue) {
        searchResultsSorted = (ArrayList<Song>) SongPredicate.filterSongs(songs, SongPredicate.hasSameSongTitle(newValue));
        System.out.println(searchResultsSorted);
        //Search ready fire property to client.
        support.firePropertyChange("newSearch", null, searchResultsSorted);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }
}
