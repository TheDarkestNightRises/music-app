package musicApp.database.playlist;

import musicApp.server.model.*;

import java.util.ArrayList;

public interface PlaylistDAO
{
  void createPlayList(String title, String description, String picture, User user);
  void deletePlayList(Playlist playlist);
  void deletePlayListById(int id);
  Album getPlayListById(int id);
  void updatePlaylist(Playlist playlist);
  void insertSongIntoPlaylist(Playlist playlist, Song song);
  ArrayList<Song> getAllSongsFromPlayList(Playlist playlist);
}
