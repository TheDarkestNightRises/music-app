package musicApp.client.model.addAlbum;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

public interface AddAlbumManager
{
  String uploadAlbumImage(String username, byte[] toByteArray);
  Artist getArtist(User user);
}
