package musicApp.server.model.updateSettings;

import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.serverData.filemanager.FileManager;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerModelUpdateSettingsImpl implements ServerModelUpdateSettings
{
  /**
   * Model for Update Settings
   */
  private UsersDAO dao;
  private FileManager fileManager;

  /**
   * initialises the dao and fileManager
   * @throws RuntimeException
   */
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

  /**
   * delegates creating the user to the dao
   * @param username
   * @param password
   * @param email
   * @param nickname
   * @param description
   * throws RuntimeException if data cannot be updated
   */
  @Override public void updateUserInfo(String username, String password,
      String email, String nickname, String description)
  {
    try {
      dao.updateUserInfo(username, password, email, nickname, description);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Cannot connect to database");
    }
  }

  /**
   * generates file name for picture, delegates updating picture path to the dao, delegates creating of image file to the fileManager
   * @param username
   * @param bytes
   * @return picture file path if it created successfully, null otherwise
   */
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
