package musicApp.database.song;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.Album;

import java.util.ArrayList;

public interface SongDAO
{
  ArrayList<Song> getAllSongs();
  void insertSong(Song song, Album album, Artist artist);
  void deleteSong(Song song) throws Exception;
  void deleteSongById(int id);
  Song getSongById(int id);
  void updateSong(Song song);
  ArrayList<Song> getSongsFromAlbum(Album album);
  ArrayList<Song> getLast4Songs();
  ArrayList<Song> get4RandomSongs();
}
