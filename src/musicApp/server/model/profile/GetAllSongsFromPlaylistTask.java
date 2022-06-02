package musicApp.server.model.profile;

import javafx.concurrent.Task;
import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.database.profile.ProfileDAO;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

/**
 * Task that gets all the songs from the playlist. It runs on a separate thread
 */
public class GetAllSongsFromPlaylistTask extends Task {
    private ProfileDAO profileDAO;
    private Playlist playlist;

    public GetAllSongsFromPlaylistTask(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    protected ArrayList<Song> call() throws Exception {
        PlaylistDAO playlistDAO = PlaylistDAOImpl.getInstance();
        return playlistDAO.getAllSongsFromPlayList(playlist);
    }
}
