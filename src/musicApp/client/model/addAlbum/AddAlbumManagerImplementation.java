package musicApp.client.model.addAlbum;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

public class AddAlbumManagerImplementation implements AddAlbumManager
{
  private Client client;

  public AddAlbumManagerImplementation(Client client)
  {
    this.client = client;
  }

  @Override public String uploadAlbumImage(String username, byte[] toByteArray)
  {
    return client.getAddAlbumClient().uploadAlbumImage(username, toByteArray);
  }

  @Override public Artist getArtist(User user)
  {
    return client.getAddAlbumClient().getArtist(user);
  }

  @Override public void createAlbum(String title, int year, String uploaded, Artist artist)
  {
     client.getAddAlbumClient().createAlbum(title,year,uploaded,artist);
  }
}
