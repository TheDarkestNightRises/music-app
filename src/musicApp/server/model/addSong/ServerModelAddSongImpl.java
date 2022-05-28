package musicApp.server.model.addSong;

import musicApp.database.artist.ArtistDAO;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.database.song.SongDAO;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.server.serverData.filemanager.FileManager;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ServerModelAddSongImpl implements ServerModelAddSong
{
  private ArtistDAO artistDAO;
  private FileManager fileManager;
  private SongDAO songDAO;

  public ServerModelAddSongImpl()
  {
    try
    {
      artistDAO = ArtistDAOImpl.getInstance();
      songDAO = SongDAOImpl.getInstance();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    fileManager = FileManager.getInstance();
  }

  @Override public ArrayList<Album> getAlbumsOfUser(User user) throws Exception
  {
    Artist artist = getArtistOfUser(user);
    if (artist != null)
    {
      ArrayList<Album> albums = artistDAO.getArtistAlbums(artist);
      if (albums != null)
      {
        return albums;
      }
      else
      {
        throw new Exception("Could not retrieve albums");
      }
    }
    else
    {
      throw new Exception("This user is not an artist!");
    }
  }

  @Override public Artist getArtistOfUser(User user)
  {
    try
    {
      return artistDAO.getArtistByName(user.getUsername());
    }
    catch (SQLException e)
    {
      return null;
    }
  }

  @Override public void addSong(String title, byte[] songBytes, Album album, User user) throws Exception
  {
    try
    {
      Artist artist = artistDAO.getArtistByName(user.getUsername());
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS");
      String songName = user.getUsername() + "_" + LocalDateTime.now().format(formatter) + ".m4a";
      fileManager.uploadSong(songName, songBytes);
      Song song = new Song(-1, title, songName, "01:00", album, artist);
      songDAO.insertSong(song, album, artist);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new Exception("Could not create song");
    }

  }

}
