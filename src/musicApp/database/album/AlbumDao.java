package musicApp.database.album;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Artist;


import java.util.ArrayList;

public interface AlbumDao
{
  ArrayList<Album> getAllAlbums();
  void createAlbum(String title, int publication_year, String picture, Artist artist);
  void deleteAlbum(Album album);
  void deleteAlbumById(int id);
  Album getAlbumById(int id);
  void updateAlbum(Album album);
  ArrayList<Album> get4RandomAlbums();



}
