package musicApp.server.model.addAlbum;

import musicApp.database.album.AlbumDAOImpl;
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

  /**
   * This methos is used to import an image from computer and rename it after the user and some random numbers
   * @param username this is used to rename the image
   * @param toByteArray ?
   * @return
   */
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

  /**
   * this method is used to get the artist in order to create an album
   * @param user this is the artist since artist extends user
   * @return an artist
   */
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

  /**
   * this methods create an album
   * @param title this is the title of the album
   * @param year this is the year of publishing the album
   * @param uploaded this is the file path of the album cover
   * @param artist this is the artist that created the album
   */
  @Override public void createAlbum(String title, int year, String uploaded, Artist artist)
  {
    try
    {
      AlbumDAOImpl.getInstance().createAlbum(title,year,uploaded,artist);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
