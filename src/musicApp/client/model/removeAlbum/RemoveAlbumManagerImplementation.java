package musicApp.client.model.removeAlbum;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Album;

import java.beans.PropertyChangeSupport;

public class RemoveAlbumManagerImplementation implements RemoveAlbumManager
{
  private Client client;

  public RemoveAlbumManagerImplementation(Client client)
  {
    this.client = client;
  }

  @Override public void deleteAlbum(Album album)
  {
    client.getRemoveAlbumClient().deleteAlbum(album);
  }
}