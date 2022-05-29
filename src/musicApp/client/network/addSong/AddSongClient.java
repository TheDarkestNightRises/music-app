package musicApp.client.network.addSong;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.util.ArrayList;

public interface AddSongClient
{
  ArrayList<Album> getAlbumsOfUser(User user) throws Exception;
  void addSong(String title, byte[] songBytes, Album album, User user)
      throws Exception;
}
