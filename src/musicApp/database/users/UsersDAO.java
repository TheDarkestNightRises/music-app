package musicApp.database.users;

import musicApp.database.song.Song;

import java.sql.SQLException;

public interface UsersDAO
{
  User createUser(String username, String password, String email) throws  SQLException;
  boolean accountExists(String username, String password) throws SQLException;
  boolean usernameExists(String username) throws SQLException;
  User getUserByName(String username);
}