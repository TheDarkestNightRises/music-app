package musicApp.server.model.createPlaylist;

import musicApp.server.model.domainModel.User;

public interface ServerModelCreatePlaylist
{

  void createPlaylist(String title, String description, User user) throws Exception;
}
