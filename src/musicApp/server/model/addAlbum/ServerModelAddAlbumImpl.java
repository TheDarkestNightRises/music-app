package musicApp.server.model.addAlbum;

import musicApp.database.artist.ArtistDAOImpl;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;
import musicApp.server.serverData.filemanager.FileManager;

import java.sql.SQLException;
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
    try
    {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS");
      String pictureName = username + "_" + LocalDateTime.now().format(formatter) + ".png";
      fileManager.uploadAlbumPicture(pictureName, toByteArray);
      fileManager.uploadAlbumPictureInOut(pictureName, toByteArray);
      return pictureName;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
  }

  @Override public Artist getArtist(User user)
  {
    try
    {
      return ArtistDAOImpl.getInstance().getArtistByName(user.getUsername());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
