package musicApp.server.model.removeAlbum;

import musicApp.database.album.AlbumDAOImpl;
import musicApp.server.model.domainModel.Album;

import java.sql.SQLException;

public class ServerModelRemoveAlbumImpl implements ServerModelRemoveAlbum
{
  @Override public void removeAlbum(Album album)
  {
    try
    {
      AlbumDAOImpl.getInstance().deleteAlbum(album);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
