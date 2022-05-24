package musicApp.database.playlist;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public interface PlaylistDAO
{
  void createPlayList(String title, String description, String picture, User user);
  void deletePlayList(Playlist playlist);
  void deletePlayListById(int id);
  void updatePlaylist(Playlist playlist,User user);
  void insertSongIntoPlaylist(Playlist playlist, Song song) throws Exception;
  void removeSongFromPlaylist(Playlist playlist, Song song);
  ArrayList<Song> getAllSongsFromPlayList(Playlist playlist);
  boolean songIsNotInThePlaylist(Playlist playlist, Song song);
}
