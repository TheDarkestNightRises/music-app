package musicApp.server.model.search;

import musicApp.database.song.SongDAO;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Song;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelSearchImpl implements ServerModelSearch{
    private ArrayList<Song> songs;
    private ArrayList<Song> searchResultsSorted;
    private SongDAO songDAO;

    public ServerModelSearchImpl() {
        try {
            this.songDAO = SongDAOImpl.getInstance();
            this.searchResultsSorted = new ArrayList<>();
            this.songs = songDAO.getAllSongs();
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
    }
}
