package musicApp.server.model.deleteSong;

import musicApp.database.artist.ArtistDAO;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.database.song.SongDAO;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelDeleteSongImpl implements ServerModelDeleteSong
{
  private ArtistDAO artistDAO;
  private SongDAO songDAO;

  public ServerModelDeleteSongImpl()
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
  }

  @Override public ArrayList<Song> getSongsOfUser(User user) throws Exception
  {
    Artist artist = getArtistOfUser(user);
    if (artist != null)
    {
      ArrayList<Album> albums = artistDAO.getArtistAlbums(artist);
      if (albums != null)
      {
        ArrayList<Song> songs = new ArrayList<>();
        for (Album album : albums)
          songs.addAll(album.getSongs());
        return songs;
      }
      else
      {
        throw new Exception("Could not retrieve songs");
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

  @Override public void deleteSong(Song song) throws Exception
  {
    songDAO.deleteSong(song);
  }
}
