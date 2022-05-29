package musicApp.client.network.createPlaylist;

import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

public interface CreatePlaylistClient
{
  void createPlaylist(String title, String description, User user) throws Exception;
}
