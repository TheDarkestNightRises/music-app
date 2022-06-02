package musicApp.client.model.addToPlaylist;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;


public class AddToPlaylistImplementation implements AddToPlaylistManager
{
  private Client client;
  public AddToPlaylistImplementation(Client client)
  {
    this.client = client;
  }

  @Override public void addToPlaylist(User user, Playlist playlist,
      Song currentSong) throws Exception
  {
      client.getAddToPlaylistClient().addToPlaylist(user, playlist, currentSong);
  }
}
