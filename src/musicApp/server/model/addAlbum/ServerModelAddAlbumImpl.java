package musicApp.server.model.addAlbum;

import musicApp.server.serverData.filemanager.FileManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerModelAddAlbumImpl implements ServerModelAddAlbum
{

  private FileManager fileManager;

  public ServerModelAddAlbumImpl()
  {
    this.fileManager = FileManager.getInstance();
  }

  @Override public String uploadAlbumPicture(String username, byte[] toByteArray)
  {
    try{
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS");
      String pictureName = username + "_" + LocalDateTime.now().format(formatter) + ".png";
      fileManager.uploadAlbumPicture(pictureName, toByteArray);
      return pictureName;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
  }
}
