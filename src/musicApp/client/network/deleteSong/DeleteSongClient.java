package musicApp.client.network.deleteSong;

import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.util.ArrayList;

public interface DeleteSongClient
{
  ArrayList<Song> getSongsOfUser(User user) throws Exception;
  void deleteSong(Song song) throws Exception;
}
