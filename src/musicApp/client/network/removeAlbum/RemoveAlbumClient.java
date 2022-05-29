package musicApp.client.network.removeAlbum;

import musicApp.server.model.domainModel.Album;
import musicApp.shared.networking.RMIServer;

public interface RemoveAlbumClient
{
  void deleteAlbum(Album album);
}
