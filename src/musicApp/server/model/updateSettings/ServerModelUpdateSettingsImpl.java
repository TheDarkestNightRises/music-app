package musicApp.server.model.updateSettings;

import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.serverData.filemanager.FileManager;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerModelUpdateSettingsImpl implements ServerModelUpdateSettings
{
  private UsersDAO dao;
  private FileManager fileManager;

  public ServerModelUpdateSettingsImpl() throws RuntimeException
  {
    try {
      dao = UsersDAOImpl.getInstance();
      fileManager = FileManager.getInstance();
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

  @Override public String uploadPicture(String username, byte[] bytes)
  {
    try{
      System.out.println("server model");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS");
      String pictureName = username + "_" + LocalDateTime.now().format(formatter) + ".png";
      dao.uploadPicture(username, pictureName);
      fileManager.uploadProfilePicture(pictureName, bytes);
      fileManager.uploadProfilePictureInOut(pictureName, bytes);
      return pictureName;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
  }

}
