package musicApp.client.network.addAlbum;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

public interface AddAlbumClient
{
  String uploadAlbumImage(String username, byte[] toByteArray);
  Artist getArtist(User user);
  void createAlbum(String title, int year, String uploaded, Artist artist);
}
