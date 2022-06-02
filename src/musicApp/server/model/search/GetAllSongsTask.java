package musicApp.server.model.search;

import javafx.concurrent.Task;
import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.database.profile.ProfileDAO;
import musicApp.database.song.SongDAO;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Task that will get all the songs from the database. Runs on separate thread
 */
public class GetAllSongsTask extends Task<ArrayList<Song>> {
    private SongDAO songDAO;

    public GetAllSongsTask() {
        try {
            this.songDAO = SongDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ArrayList<Song> call()  {
        return songDAO.getAllSongs();
    }
}
