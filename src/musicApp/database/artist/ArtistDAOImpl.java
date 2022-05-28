package musicApp.database.artist;

import musicApp.database.ConnectionFactory;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.Song;

import java.sql.*;
import java.util.ArrayList;

public class ArtistDAOImpl implements ArtistDAO
{

  private static ArtistDAOImpl instance;
  private Connection connection;

  public ArtistDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
    connection = getConnection();
  }

  private Connection getConnection() throws SQLException
  {
    Connection conn;
    conn = ConnectionFactory.getInstance().getConnection();
    return conn;
  }

  public static synchronized ArtistDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new ArtistDAOImpl();
    }
    return instance;
  }

  @Override public ArrayList<Artist> getAllArtists()
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM artist");
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Artist> list = new ArrayList<>();
      while (resultSet.next())
      {
        String name = resultSet.getString("username");
        Artist artist = new Artist();
        artist.setName(name);
        artist.setAlbums(getArtistAlbums(artist));
        list.add(artist);
      }
      return list;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void insertArtist(String username)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("INSERT INTO artist(username) " + "VALUES (?);");
      statement.setString(1, username);
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  @Override public void deleteArtist(Artist artist)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("DELETE FROM artist WHERE username = ?");
      statement.setString(1, artist.getName());
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Artist getArtistByName(String username)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM artist WHERE username = ?");
      statement.setString(1, username);
      statement0.execute();
      statement.execute();
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String name = resultSet.getString("username");
        Artist artist = new Artist();
        artist.setName(name);
        artist.setAlbums(getArtistAlbums(artist));
        return artist;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void updateArtistName(Artist artist, String name)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("UPDATE artist SET username = ? where username = ?");
      statement.setString(1, name);
      statement.setString(1, artist.getName());
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  @Override public ArrayList<Album> getArtistAlbums(Artist artist) throws SQLException
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("Select * FROM Album where username = ?");
      statement.setString(1, artist.getName());
      statement0.execute();
      statement.execute();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Album> albums = new ArrayList<>();
      while (resultSet.next())
      {
        int id = resultSet.getInt("album_id");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("publication_year");
        String picture = resultSet.getString("picture_path");
        ArrayList<Song> songs = new ArrayList<>();
        Album album = new Album(id, title, year, picture, artist, songs);
        PreparedStatement statement2 = connection.prepareStatement("Select * FROM song where album_id = ?");
        statement2.setInt(1, id);
        ResultSet resultSet2 = statement2.executeQuery();
        while (resultSet2.next())
        {
          int song_id = resultSet2.getInt("song_id");
          String song_title = resultSet2.getString("title");
          String length = resultSet2.getString("length");
          String file = resultSet2.getString("file_path");
          Song song = new Song(song_id, song_title, file, length, album, artist);
          songs.add(song);
        }
        albums.add(album);
      }
      return albums;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
