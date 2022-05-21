package musicApp.server.model.createPlaylist;

import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;

public class ServerModelCreatePlaylistImpl implements ServerModelCreatePlaylist
{
  PlaylistDAO playlistDAO;

  public ServerModelCreatePlaylistImpl()
  {
    try
    {
      playlistDAO = PlaylistDAOImpl.getInstance();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  @Override public void createPlaylist(String title, String description,
      User user) throws Exception
  {
    try{
      playlistDAO.createPlayList(title, description, "", user);
    }
    catch (Exception e)
    {
      throw new Exception("Could not create playlist");
    }
  }
}
