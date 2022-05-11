package musicApp.database.artist;

import musicApp.client.model.Artist;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ArtistDAO
{
  ArrayList<Artist> getAllArtists() throws SQLException;
  void insertArtist(String username) throws SQLException;
  void deleteArtist(Artist artist) throws SQLException;
  Artist getArtistByName(String username) throws SQLException;
  void updateArtist(Artist artist) throws SQLException;
}
