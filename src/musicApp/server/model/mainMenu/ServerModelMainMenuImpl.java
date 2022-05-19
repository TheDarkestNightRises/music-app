package musicApp.server.model.mainMenu;

import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.album.AlbumDao;
import musicApp.database.song.SongDAO;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelMainMenuImpl implements ServerModelMainMenu{
    private SongDAO songDAO;
    private AlbumDao albumDao;

    public ServerModelMainMenuImpl() {
        try {
            this.songDAO = SongDAOImpl.getInstance();
            this.albumDao = AlbumDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Song> fetchRandomSongs() {
        return songDAO.get4RandomSongs();
    }

    @Override
    public ArrayList<Song> fetchLastSongs() {
        return songDAO.getLast4Songs();
    }

    @Override
    public ArrayList<Album> fetchRandomAlbums() {
        return albumDao.get4RandomAlbums();
    }
}
