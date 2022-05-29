package musicApp.client.network.addToPlaylist;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

public interface AddToPlaylistClient
{
  void addToPlaylist(User user, Playlist playlist, Song currentSong)
      throws Exception;
}
