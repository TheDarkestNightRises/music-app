package musicApp.database.profile;

import musicApp.database.users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProfileDAO
{

  ArrayList<Playlist> getUserPlaylists(User user);
  ArrayList<Integer> getSongIdsByPlaylist(Playlist playlist);
  void updateUserInfo(User user);
}
