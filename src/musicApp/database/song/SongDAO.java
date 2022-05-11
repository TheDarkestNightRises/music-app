package musicApp.database.song;

import musicApp.server.model.Song;
import musicApp.server.model.Album;

import java.util.ArrayList;

public interface SongDAO
{
  ArrayList<Song> getAllSongs();
  void insertSong(Song song,Album album);
  void deleteSong(Song song,Album album);
  Song getSongByName(Song song);
  void updateSong();
  ArrayList<Song> getSongsFromAlbum(Album album);

}
