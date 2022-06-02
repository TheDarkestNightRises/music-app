package musicApp.server.model.removePlaylist;

import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.removeAlbum.ServerModelRemoveAlbum;

import java.sql.SQLException;

public class ServerModelRemovePlaylistImpl implements ServerModelRemovePlaylist
{
  /**
   * This method deletes a playlist
   * @param playlist the playlist that will be deleted
   */
  @Override public void removePlaylist(Playlist playlist)
  {
    try
    {
      PlaylistDAOImpl.getInstance().deletePlayList(playlist);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
