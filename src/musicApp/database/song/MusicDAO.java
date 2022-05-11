package musicApp.database.song;

import musicApp.client.model.Song;
import musicApp.client.model.Album;

import java.util.ArrayList;

public interface MusicDAO
{
  ArrayList<Song> getAllSongs();
  void insertSong(Song song,Album album);
  void deleteSong(Song song,Album album);
  Song getSongByName(Song song);
  void updateSong();
  ArrayList<Song> getSongsFromAlbum();
  ArrayList<Song> getSongsFromArtists();


}
