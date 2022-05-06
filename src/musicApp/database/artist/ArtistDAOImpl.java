package musicApp.database.artist;

import musicApp.database.song.Song;
import musicApp.database.users.User;
import musicApp.database.users.UsersDAOImpl;

import java.sql.*;
import java.util.ArrayList;

public class ArtistDAOImpl implements ArtistDAO
{

  private static ArtistDAOImpl instance;
  public static String URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/viinvdnw";
  public static String USERNAME = "viinvdnw";
  public static String PASSWORD = "RYTBFOCvnjTJFnAoOA-XeuvHE7sdLyV-";

  public ArtistDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized ArtistDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new ArtistDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(URL,USERNAME,PASSWORD);
  }

  @Override public ArrayList<Artist> getAllArtists()
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM artist");
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Artist> list = new ArrayList<>();
      while(resultSet.next())
      {
        String name = resultSet.getString("username");
        Artist artist = new Artist();
        artist.setName(name);
        list.add(artist);
      }
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void insertArtist(String username)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("INSERT INTO artist(username) "
          + "VALUES (?);");
      statement.setString(1,username);
      statement0.executeUpdate();
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override public void deleteArtist(Artist artist)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("DELETE FROM artist WHERE username = ?");
      statement.setString(1, artist.getName());
      statement0.executeUpdate();
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override public Artist getArtistByName(String username)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM artist WHERE username = ?");
      statement.setString(1, username);
      statement0.execute();
      statement.execute();
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next())
      {
        String name = resultSet.getString("username");
        Artist artist = new Artist();
        artist.setName(name);
        return artist;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void updateArtist(Artist artist)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("UPDATE artist SET username = ?");
      statement.setString(1, artist.getName());
      statement0.executeUpdate();
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
