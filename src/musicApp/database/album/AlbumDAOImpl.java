package musicApp.database.album;

import musicApp.server.model.Album;
import musicApp.server.model.Artist;

import java.sql.*;
import java.util.ArrayList;

public class AlbumDAOImpl
{

  private static AlbumDAOImpl instance;
  public static String URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/viinvdnw";
  public static String USERNAME = "viinvdnw";
  public static String PASSWORD = "RYTBFOCvnjTJFnAoOA-XeuvHE7sdLyV-";

  public AlbumDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized AlbumDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new AlbumDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(URL,USERNAME,PASSWORD);
  }

//  @Override public ArrayList<Album> getAllAlbums()
//  {
//    try (Connection connection = getConnection())
//    {
//      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
//      PreparedStatement statement = connection.prepareStatement("SELECT * FROM album");
//      statement0.executeUpdate();
//      ResultSet resultSet = statement.executeQuery();
//      ArrayList<Album> list = new ArrayList<>();
//      while(resultSet.next())
//      {
//        int id = resultSet.getInt("album_id");
//        String title = resultSet.getString("title");
//        int year = resultSet.getInt("publication_year");
//        String picture = resultSet.getString("picture_path");
//        String username = resultSet.getString("username");
//        Album album = new Album();
//        album.setId(id);
//        album.setTitle(title);
//        album.setPublicationYear(year);
//        album.setPicturePath(picture);
//        album.setArtist(username);
//        list.add(album);
//      }
//      return list;
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return null;
//  }

//  @Override public void insertAlbum(String title, int publication_year, String picture, Artist artist)
//  {
//    try (Connection connection = getConnection())
//    {
//      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
//      PreparedStatement statement = connection.prepareStatement("INSERT INTO album(title, publication_year, picture_path, username) "
//          + "VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
//
//      statement.setString(1,title);
//      statement.setInt(2,publication_year);
//      statement.setString(3,picture);
//      statement.setString(4,artist.getName());
//      statement0.executeUpdate();
//      statement.executeUpdate();
//      statement.getGeneratedKeys();//database should auto generate keys
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//  }
//
//  @Override public void deleteAlbum(Album album)
//  {
//    try (Connection connection = getConnection())
//    {
//      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
//      PreparedStatement statement = connection.prepareStatement("DELETE FROM album WHERE album_id = ?");
//      statement.setInt(1, album.getId());
//      statement0.executeUpdate();
//      statement.executeUpdate();
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//  }

//  @Override public Album getAlbumById(int id)
//  {
//    try (Connection connection = getConnection())
//    {
//      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
//      PreparedStatement statement = connection.prepareStatement("SELECT * FROM album WHERE album_id = ?");
//      statement.setInt(1, id);
//      statement0.execute();
//      statement.execute();
//      ResultSet resultSet = statement.executeQuery();
//      if(resultSet.next())
//      {
//        String title = resultSet.getString("title");
//        int year = resultSet.getInt("publication_year");
//        String picture = resultSet.getString("picture_path");
//        String username = resultSet.getString("username");
//        Album album = new Album();
//        album.setId(id);
//        album.setTitle(title);
//        album.setPublicationYear(year);
//        album.setPicturePath(picture);
//        album.setUsername(username);
//        return album;
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return null;
//  }

//  @Override public void updateAlbum(Album album)
//  {
//    try (Connection connection = getConnection())
//    {
//      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
//      PreparedStatement statement = connection.prepareStatement("UPDATE album SET username = ?");
//      statement.setInt(1, album.getId());
//      statement.setString(2,album.getTitle());
//      statement.setInt(3,album.getPublicationYear());
//      statement.setString(4,album.getPicturePath());
//      statement.setString(5,album.getUsername());
//      statement0.executeUpdate();
//      statement.executeUpdate();
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//  }
//
//  @Override public ArrayList<Album> getArtistAlbums(Artist artist)
//  {
//    try (Connection connection = getConnection())
//    {
//      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
//      PreparedStatement statement = connection.prepareStatement("SELECT * FROM album WHERE username = ?");
//      statement.setString(1, artist.getName());
//      statement0.execute();
//      statement.execute();
//      ResultSet resultSet = statement.executeQuery();
//      ArrayList<Album> list = new ArrayList<>();
//      while(resultSet.next())
//      {
//        int id = resultSet.getInt("album_id");
//        String title = resultSet.getString("title");
//        int year = resultSet.getInt("publication_year");
//        String picture = resultSet.getString("picture_path");
//        String username = resultSet.getString("username");
//        Album album = new Album();
//        album.setId(id);
//        album.setTitle(title);
//        album.setPublicationYear(year);
//        album.setPicturePath(picture);
//        album.setUsername(username);
//        list.add(album);
//      }
//      return list;
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return null;
//  }
}
