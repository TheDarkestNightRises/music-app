package musicApp.client.model.deleteSong;

import musicApp.client.network.Client;

public class DeleteSongManagerImplementation implements DeleteSongManager
{
  Client client;
  public DeleteSongManagerImplementation(Client client)
  {
    this.client = client;
  }
}
