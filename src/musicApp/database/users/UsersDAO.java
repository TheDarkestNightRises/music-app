package musicApp.database.users;

import musicApp.server.model.Playlist;
import musicApp.server.model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UsersDAO
{
  User createUser(String username, String password, String email) throws  SQLException;
  boolean accountExists(String username, String password) throws SQLException;
  boolean usernameExists(String username) throws SQLException;
  User getUserByName(String username);
  Playlist getPlaylistFromUserById(User user, int id);
  ArrayList<Playlist> getAllPlaylistsFromUser(User user);
}
