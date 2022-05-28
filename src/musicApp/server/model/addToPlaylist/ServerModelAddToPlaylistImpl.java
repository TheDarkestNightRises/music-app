package musicApp.server.model.addToPlaylist;

import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;

public class ServerModelAddToPlaylistImpl implements ServerModelAddToPlaylist
{
  private PlaylistDAO dao;

  public ServerModelAddToPlaylistImpl()
  {
    try
    {
      dao = PlaylistDAOImpl.getInstance();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addToPlaylist(User user, Playlist playlist, Song currentSong) throws Exception
  {
    dao.insertSongIntoPlaylist(playlist, currentSong);
  }

}
