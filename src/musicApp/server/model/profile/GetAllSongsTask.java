package musicApp.server.model.profile;

import javafx.concurrent.Task;
import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.database.profile.ProfileDAO;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

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
