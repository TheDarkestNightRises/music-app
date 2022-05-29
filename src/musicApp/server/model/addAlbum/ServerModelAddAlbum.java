package musicApp.server.model.addAlbum;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

public interface ServerModelAddAlbum
{
  String uploadAlbumPicture(String username, byte[] toByteArray);
  Artist getArtist(User user);
  void createAlbum(String title, int year, String uploaded, Artist artist);
}
