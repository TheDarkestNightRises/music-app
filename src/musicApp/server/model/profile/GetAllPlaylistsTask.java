package musicApp.server.model.profile;

import javafx.concurrent.Task;
import musicApp.database.profile.ProfileDAO;
import musicApp.database.profile.ProfileDAOImpl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

/**
 * Task that gets all the playlists from the model . It runs in a separate thread
 */
public class GetAllPlaylistsTask extends Task {
    private ProfileDAO profileDAO;
    private User user;

    public GetAllPlaylistsTask(User user) {
        this.user = user;
    }

    @Override
    protected ArrayList<Playlist> call() throws Exception {
        profileDAO = ProfileDAOImpl.getInstance();
        return profileDAO.fetchPlaylistsForUser(user);
    }
}
