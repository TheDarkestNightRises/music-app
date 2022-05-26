package musicApp.client.model.addSong;

import musicApp.client.network.Client;

public class AddSongManagerImpl implements AddSongManager
{
  private Client client;
  public AddSongManagerImpl(Client client)
  {
    this.client = client;
  }
}
