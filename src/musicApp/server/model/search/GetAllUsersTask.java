package musicApp.server.model.search;

import javafx.concurrent.Task;
import musicApp.database.song.SongDAOImpl;
import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Task that will get all the users from the database. Runs on separate thread
 */
public class GetAllUsersTask extends Task {
    private UsersDAO userDAO;

    public GetAllUsersTask() {
        try {
            this.userDAO = UsersDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ArrayList<User> call()  {
        return userDAO.getAllUsers();
    }
}
