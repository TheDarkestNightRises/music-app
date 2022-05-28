package musicApp.database.album;

import musicApp.database.ConnectionFactory;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.Song;

import java.sql.*;
import java.util.ArrayList;

public class AlbumDAOImpl implements AlbumDao
{

  private static AlbumDAOImpl instance;
  private Connection connection;

  public AlbumDAOImpl() throws SQLException
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

  public static synchronized AlbumDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new AlbumDAOImpl();
    }
    return instance;
  }

  @Override public ArrayList<Album> getAllAlbums()
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM album");
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Album> list = new ArrayList<>();
      while (resultSet.next())
      {
        int id = resultSet.getInt("album_id");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("publication_year");
        String picture = resultSet.getString("picture_path");
        String name = resultSet.getString("username");
        Artist artist = new Artist();
        artist.setName(name);
        artist.setAlbums(ArtistDAOImpl.getInstance().getArtistAlbums(artist));
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
        list.add(album);
      }
      return list;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void createAlbum(String title, int publication_year, String picture, Artist artist)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO album(title, publication_year, picture_path, username) " + "VALUES (?, ?, ?, ?);",
          Statement.RETURN_GENERATED_KEYS);

      statement.setString(1, title);
      statement.setInt(2, publication_year);
      statement.setString(3, picture);
      statement.setString(4, artist.getName());
      statement0.executeUpdate();
      statement.executeUpdate();
      statement.getGeneratedKeys();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteAlbum(Album album)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("DELETE FROM album WHERE album_id = ?");
      statement.setInt(1, album.getId());
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteAlbumById(int id)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("DELETE FROM album WHERE album_id = ?");
      statement.setInt(1, id);
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Album getAlbumById(int id)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM album where album_id = ?");
      statement.setInt(1, id);
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        int id1 = resultSet.getInt("album_id");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("publication_year");
        String picture = resultSet.getString("picture_path");
        String name = resultSet.getString("username");
        Artist artist = new Artist();
        artist.setName(name);
        artist.setAlbums(ArtistDAOImpl.getInstance().getArtistAlbums(artist));
        ArrayList<Song> songs = new ArrayList<>();
        Album album = new Album(id, title, year, picture, artist, songs);
        PreparedStatement statement2 = connection.prepareStatement("Select * FROM song where album_id = ?");
        statement2.setInt(1, id1);
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
        return album;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void updateAlbum(Album album)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE album SET  title = ?,  publication_year = ?," + " picture_path = ?, username = ? where album_id = ?");
      statement.setString(1, album.getTitle());
      statement.setInt(2, album.getPublicationYear());
      statement.setString(3, album.getPicturePath());
      statement.setString(4, album.getArtist().getName());
      statement.setInt(5, album.getId());
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public ArrayList<Album> get4RandomAlbums()
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM album ORDER BY random() LIMIT 4;");
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Album> list = new ArrayList<>();
      while (resultSet.next())
      {
        int id = resultSet.getInt("album_id");
        String title = resultSet.getString("title");
        int year = resultSet.getInt("publication_year");
        String picture = resultSet.getString("picture_path");
        String name = resultSet.getString("username");
        Artist artist = new Artist();
        artist.setName(name);
        artist.setAlbums(ArtistDAOImpl.getInstance().getArtistAlbums(artist));
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
        list.add(album);
      }
      return list;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

}
