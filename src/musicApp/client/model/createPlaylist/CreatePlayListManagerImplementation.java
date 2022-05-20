package musicApp.client.model.createPlaylist;

import musicApp.client.network.Client;

public class CreatePlayListManagerImplementation implements CreatePlaylistManager
{
  private Client client;
  public CreatePlayListManagerImplementation(Client client)
  {
    this.client = client;
  }
}
