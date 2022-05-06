package musicApp.database.album;

import musicApp.database.artist.Artist;
import musicApp.database.song.Song;

import java.util.ArrayList;

public interface AlbumDao
{
  ArrayList<Album> getAllAlbums();
  void insertAlbum( String title, int publication_year, String picture, Artist artist);
  void deleteAlbum(Album album);
  Album getAlbumById(int id);
  void updateAlbum(Album album);
  ArrayList<Album> getArtistAlbums(Artist artist);
}
