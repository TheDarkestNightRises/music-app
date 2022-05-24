package musicApp.client.model.addToPlaylist;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

public interface AddToPlaylistManager
{

  void addToPlaylist(User user, Playlist playlist, Song currentSong)
      throws Exception;
}
