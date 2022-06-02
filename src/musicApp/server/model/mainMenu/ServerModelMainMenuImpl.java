package musicApp.server.model.mainMenu;

import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.album.AlbumDao;
import musicApp.database.song.SongDAO;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is responsible for the main menu
 */
public class ServerModelMainMenuImpl implements ServerModelMainMenu{
    private SongDAO songDAO;
    private AlbumDao albumDao;

    /**
     * This has a reference to the songDao and albumDao to use them to access the data from database
     */
    public ServerModelMainMenuImpl() {
        try {
            this.songDAO = SongDAOImpl.getInstance();
            this.albumDao = AlbumDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delegates to Song Dao to get 4 random songs
     * @return 4 random songs
     */
    @Override
    public ArrayList<Song> fetchRandomSongs() {
        return songDAO.get4RandomSongs();
    }

    /**
     * Delegates to Song Dao to get the last songs
     * @return last songs
     */
    @Override
    public ArrayList<Song> fetchLastSongs() {
        return songDAO.getLast4Songs();
    }

    /**
     * Delegates to Song Dao to get 4 random albums
     * @return 4 random albums
     */
    @Override
    public ArrayList<Album> fetchRandomAlbums() {
        return albumDao.get4RandomAlbums();
    }
}
