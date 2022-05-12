package musicApp.database.song;

import musicApp.server.model.Artist;
import musicApp.server.model.Song;
import musicApp.server.model.Album;

import java.util.ArrayList;

public interface SongDAO
{
  ArrayList<Song> getAllSongs();
  void insertSong(Song song, Album album, Artist artist);
  void deleteSong(Song song);
  void deleteSongById(int id);
  Song getSongById(int id);
  void updateSong(Song song);
  ArrayList<Song> getSongsFromAlbum(Album album);

}
