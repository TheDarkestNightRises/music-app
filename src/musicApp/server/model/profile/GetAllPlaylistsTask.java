package musicApp.server.model.profile;

import javafx.concurrent.Task;
import musicApp.database.profile.ProfileDAO;
import musicApp.database.profile.ProfileDAOImpl;
import musicApp.server.model.Playlist;
import musicApp.server.model.User;

import java.util.ArrayList;

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
