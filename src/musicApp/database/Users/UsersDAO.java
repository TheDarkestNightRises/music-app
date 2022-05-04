package musicApp.database.Users;

import java.sql.SQLException;

public interface UsersDAO
{
  User createUser(String username, String password, String email) throws  SQLException;
  boolean accountExists(String username, String password) throws SQLException;
}
