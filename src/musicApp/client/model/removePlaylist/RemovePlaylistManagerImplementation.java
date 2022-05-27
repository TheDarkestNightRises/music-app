package musicApp.client.model.removePlaylist;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;

import java.beans.PropertyChangeSupport;

public class RemovePlaylistManagerImplementation implements RemovePlaylistManager
{
  private Client client;

  public RemovePlaylistManagerImplementation(Client client)
  {
    this.client = client;
  }

  @Override public void deletePlaylist(Playlist playlist)
  {
    client.getRemovePlaylistClient().removePlaylist(playlist);
  }
}
