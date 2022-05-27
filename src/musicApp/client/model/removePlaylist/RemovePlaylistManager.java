package musicApp.client.model.removePlaylist;

import musicApp.server.model.domainModel.Playlist;

public interface RemovePlaylistManager
{
  void deletePlaylist(Playlist playlist);
}
