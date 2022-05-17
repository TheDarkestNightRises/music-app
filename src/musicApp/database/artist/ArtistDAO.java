package musicApp.database.artist;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Artist;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ArtistDAO
{
  ArrayList<Artist> getAllArtists() throws SQLException;
  void insertArtist(String username) throws SQLException;
  void deleteArtist(Artist artist) throws SQLException;
  Artist getArtistByName(String username) throws SQLException;
  void updateArtistName(Artist artist, String name) throws SQLException;
  ArrayList<Album> getArtistAlbums(Artist artist) throws SQLException;

}
