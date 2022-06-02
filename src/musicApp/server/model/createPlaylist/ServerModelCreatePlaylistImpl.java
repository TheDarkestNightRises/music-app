package musicApp.server.model.createPlaylist;

import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;

public class ServerModelCreatePlaylistImpl implements ServerModelCreatePlaylist
{
  PlaylistDAO playlistDAO;

  /**
   * constructor that initialises the playlistDAO
   */
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

  /**
   * delegates creation of playlist in the database to the playlistDAO
   * @param title
   * @param description
   * @param user
   * @throws Exception if the dao could not update the database
   */
  @Override public void createPlaylist(String title, String description, User user) throws Exception
  {
    try
    {
      playlistDAO.createPlayList(title, description, "", user);
    }
    catch (Exception e)
    {
      throw new Exception("Could not create playlist");
    }
  }
}
