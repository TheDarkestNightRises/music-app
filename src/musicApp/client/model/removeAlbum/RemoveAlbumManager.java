package musicApp.client.model.removeAlbum;

import musicApp.server.model.domainModel.Album;

public interface RemoveAlbumManager
{
  void deleteAlbum(Album album);
}
