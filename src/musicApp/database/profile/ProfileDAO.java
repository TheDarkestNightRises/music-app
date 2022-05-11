package musicApp.database.profile;

import musicApp.server.model.Playlist;
import musicApp.server.model.User;

import java.util.ArrayList;

public interface ProfileDAO
{

  ArrayList<Playlist> getUserPlaylists(User user);
  ArrayList<Integer> getSongIdsByPlaylist(Playlist playlist);
  void updateUserInfo(User user);
}
