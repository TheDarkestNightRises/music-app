package musicApp.client.network.removeAlbum;

import musicApp.server.model.domainModel.Album;
import musicApp.shared.networking.RMIServer;

public interface RemoveAlbumClient
{
  void setServer(RMIServer server);
  void deleteAlbum(Album album);
}
