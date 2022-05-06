package musicApp.database.album;

import musicApp.database.song.Song;

import java.util.ArrayList;

public interface AlbumDao
{
  ArrayList<Album> getAllAlbums();
  void insertAlbum(Album album);
  void deleteAlbum(Album album);
  Song getAlbumByName(Album album);
  void updateAlbum();
  ArrayList<Album> getArtistAlbums();
}
