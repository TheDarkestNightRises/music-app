package musicApp.server.model.profile;

import musicApp.database.profile.ProfileDAO;
import musicApp.database.profile.ProfileDAOImpl;
import musicApp.server.model.Playlist;
import musicApp.server.model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelProfileImpl implements ServerModelProfile {
    private ProfileDAO profileDAO;

    public ServerModelProfileImpl() {
        try {
            profileDAO = ProfileDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        return profileDAO.fetchPlaylistsForUser(user);
    }
}
