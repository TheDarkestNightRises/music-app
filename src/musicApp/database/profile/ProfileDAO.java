package musicApp.database.profile;

import musicApp.client.model.Playlist;
import musicApp.client.model.User;

import java.util.ArrayList;

public interface ProfileDAO
{

  ArrayList<Playlist> getUserPlaylists(User user);
  ArrayList<Integer> getSongIdsByPlaylist(Playlist playlist);
  void updateUserInfo(User user);
}
