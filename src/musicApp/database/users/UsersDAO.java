package musicApp.database.users;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UsersDAO
{
  User createUser(String username, String password, String email) throws  SQLException;
  boolean accountExists(String username, String password) throws SQLException;
  boolean usernameExists(String username) throws SQLException;
  User getUserByName(String username);
  Playlist getPlaylistFromUserById(User user, int id);
  Playlist getPlaylistIdFromUserByName(User user, String title);
  ArrayList<Playlist> getAllPlaylistsFromUser(User user);
  void updateUserInfo(String username, String password, String email,
      String nickname, String description);
  boolean PlaylistExists(User user, String playlistName);
  void uploadPicture(String username, String pictureName);
  ArrayList<User> getAllUsers();
}
