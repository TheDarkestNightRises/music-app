package musicApp.client.model.createPlaylist;

import musicApp.server.model.domainModel.User;

public interface CreatePlaylistManager
{
  void createPlaylist(String title, String description, User user) throws Exception;
}
