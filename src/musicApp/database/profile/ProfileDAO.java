package musicApp.database.profile;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public interface ProfileDAO
{
  ArrayList<Playlist> fetchPlaylistsForUser(User user);
  ArrayList<Integer> getSongIdsByPlaylist(Playlist playlist);
  void updateUserInfo(User user);
}
