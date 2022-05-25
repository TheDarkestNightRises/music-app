package musicApp.client.network.addAlbum;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

public interface AddAlbumClient
{
  void setServer(RMIServer server);
  String uploadAlbumImage(String username, byte[] toByteArray);
  Artist getArtist(User user);
}
