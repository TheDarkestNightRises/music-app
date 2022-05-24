package musicApp.server.model.search;

import musicApp.database.song.SongDAO;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelSearchImpl implements ServerModelSearch {
    private ArrayList<Song> songs;
    private ArrayList<Album> albums;
    private ArrayList<User> users;

    private PropertyChangeSupport support;

    public ServerModelSearchImpl() {
        this.songs = new ArrayList<>();
        this.albums = new ArrayList<>();
        this.users = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public ArrayList<Song> fetchSortedList() {
        return songs;
    }

    @Override
    public void searchSong(String newValue) {
        if (songs.isEmpty()) {
            GetAllSongsTask getAllSongs = new GetAllSongsTask();
            new Thread(getAllSongs).start();
            try {
                songs = getAllSongs.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ArrayList<Song> searchResultsSorted = SongPredicate.filterSongs(songs, SongPredicate.containsSongTitleOrContainsArtist(newValue));
        System.out.println(searchResultsSorted);
        //Search ready fire property to client.
        support.firePropertyChange("newSearchSong", null, searchResultsSorted);
    }

    @Override
    public void searchAlbum(String search) {
        if (albums.isEmpty()) {
            GetAllAlbumsTask getAllAlbums = new GetAllAlbumsTask();
            new Thread(getAllAlbums).start();
            try {
                albums = getAllAlbums.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ArrayList<Album> searchResultsSorted = AlbumPredicate.filterAlbums(albums, AlbumPredicate.containsAlbumTitleOrContainsArtist(search));
        System.out.println(searchResultsSorted);
        //Search ready fire property to client.
        support.firePropertyChange("newSearchAlbum", null, searchResultsSorted);
    }

    @Override
    public void searchProfile(String search) {
        if (users.isEmpty()) {
            GetAllUsersTask getAllUsersTask = new GetAllUsersTask();
            new Thread(getAllUsersTask).start();
            try {
                users = getAllUsersTask.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ArrayList<User> searchResultsSorted = ProfilePredicate.filterUsers(users, ProfilePredicate.hasSameUserNameOrNickName(search));
        System.out.println(searchResultsSorted);
        //Search ready fire property to client.
        support.firePropertyChange("newSearchProfile", null, searchResultsSorted);
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
