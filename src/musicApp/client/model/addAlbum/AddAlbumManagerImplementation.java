package musicApp.client.model.addAlbum;

import musicApp.client.network.Client;

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
}
