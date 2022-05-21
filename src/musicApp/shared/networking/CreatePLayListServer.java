package musicApp.shared.networking;

import musicApp.server.model.domainModel.User;

import java.rmi.Remote;

public interface CreatePLayListServer extends Remote
{
  void createPlaylist(String title, String description, User user) throws Exception;
}
