package musicApp.server.model.updateSettings;

import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;

import java.sql.SQLException;

public class ServerModelUpdateSettingsImpl implements ServerModelUpdateSettings
{
  private UsersDAO dao;

  public ServerModelUpdateSettingsImpl() throws RuntimeException
  {
    try {
      dao = UsersDAOImpl.getInstance();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void updateUserInfo(String username, String password,
      String email, String nickname)
  {
    try {
      dao.updateUserInfo(username, password, email, nickname);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Cannot connect to database");
    }
  }
  //dao
}
