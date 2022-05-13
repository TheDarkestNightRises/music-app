package musicApp.server.model.profile;

import javafx.concurrent.Task;
import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.database.profile.ProfileDAO;
import musicApp.database.profile.ProfileDAOImpl;
import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;

import java.util.ArrayList;

public class GetAllSongsTask extends Task {
    private ProfileDAO profileDAO;
    private Playlist playlist;

    public GetAllSongsTask(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    protected ArrayList<Song> call() throws Exception {
        PlaylistDAO playlistDAO = PlaylistDAOImpl.getInstance();
        return playlistDAO.getAllSongsFromPlayList(playlist);
    }
}
