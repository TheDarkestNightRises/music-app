package musicApp.client.network.addAlbum;

import musicApp.shared.networking.RMIServer;

public interface AddAlbumClient
{
  void setServer(RMIServer server);
  String uploadAlbumImage(String username, byte[] toByteArray);
}
