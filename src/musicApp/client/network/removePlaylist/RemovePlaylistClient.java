package musicApp.client.network.removePlaylist;

import musicApp.server.model.domainModel.Playlist;
import musicApp.shared.networking.RMIServer;

public interface RemovePlaylistClient
{
  void removePlaylist(Playlist playlist);
}
