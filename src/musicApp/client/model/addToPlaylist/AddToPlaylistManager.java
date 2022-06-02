package musicApp.client.model.addToPlaylist;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

/**
 * The interface for the AddToPlaylistManager,model in the client.It's used to add songs to a playlist
 */
public interface AddToPlaylistManager
{

  void addToPlaylist(User user, Playlist playlist, Song currentSong)
      throws Exception;
}
