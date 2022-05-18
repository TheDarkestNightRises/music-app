package musicApp.server.model.musicplayer;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.io.File;
import java.util.ArrayList;

public interface ServerModelMusic
{
  //-------MusicPlayer--------
  ArrayList<File> getCurrentPlaylistFiles(Playlist playlist);

  byte[] fetchAlbumCover(String picturePath);
  void addToLikedSongs(User user, Song song);
  void removeToLikedSongs(User user);
}
