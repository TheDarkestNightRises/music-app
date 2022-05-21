package musicApp.client.model.createPlaylist;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.User;

public class CreatePlayListManagerImplementation implements CreatePlaylistManager
{
  private Client client;
  public CreatePlayListManagerImplementation(Client client)
  {
    this.client = client;
  }

  @Override public void createPlaylist(String title, String description,
      User user) throws Exception
  {
    client.getCreatePlaylistClient().createPlaylist(title, description, user);
  }
}
