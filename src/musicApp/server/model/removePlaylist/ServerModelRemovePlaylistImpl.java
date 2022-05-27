package musicApp.server.model.removePlaylist;

import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.removeAlbum.ServerModelRemoveAlbum;

import java.sql.SQLException;

public class ServerModelRemovePlaylistImpl implements ServerModelRemovePlaylist
{

  @Override public void removeAlbum(Playlist playlist)
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
