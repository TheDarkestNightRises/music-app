package musicApp.shared.networking;

import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.rmi.Remote;
import java.util.ArrayList;

public interface DeleteSongServer extends Remote
{
  ArrayList<Song> getSongsOfUser(User user) throws Exception;

  void deleteSong(Song song) throws Exception;
}
