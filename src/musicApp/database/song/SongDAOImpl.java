package musicApp.database.song;

import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.server.model.Artist;
import musicApp.server.model.Song;
import musicApp.server.model.Album;

import java.sql.*;
import java.util.ArrayList;

public class SongDAOImpl implements SongDAO
{

  private static SongDAOImpl instance;
  public static String URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/viinvdnw";
  public static String USERNAME = "viinvdnw";
  public static String PASSWORD = "RYTBFOCvnjTJFnAoOA-XeuvHE7sdLyV-";

  public SongDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized SongDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new SongDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(URL,USERNAME,PASSWORD);
  }


  @Override public ArrayList<Song> getAllSongs()
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("Select * FROM Song ");
      statement0.execute();
      statement.execute();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Song> songs = new ArrayList<>();
      while(resultSet.next())
      {
        int id = resultSet.getInt("song_id");
        String title = resultSet.getString("title");
        String length = resultSet.getString("length");
        String picture = resultSet.getString("file_path");
        Album albumName = new Album();
        Artist artistName = new Artist();
        PreparedStatement statement2 = connection.prepareStatement("Select * FROM album where album_id = ?");
        int album_id = resultSet.getInt("album_id");
        statement2.setInt(1, album_id);
        ResultSet resultSet2 = statement2.executeQuery();
        if(resultSet2.next())
        {
          albumName = AlbumDAOImpl.getInstance().getAlbumById(album_id);
        }
        PreparedStatement statement3 = connection.prepareStatement("Select * FROM artist where username = ?");
        String username = resultSet.getString("username");
        statement3.setString(1, username);
        ResultSet resultSet3 = statement3.executeQuery();
        if(resultSet3.next())
        {
          artistName = ArtistDAOImpl.getInstance().getArtistByName(username);
        }
        songs.add(new Song(id,title,length,picture,albumName,artistName));
      }
      return songs;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }


  @Override public void insertSong(Song song, Album album, Artist artist)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("INSERT INTO song(title,length,file_path,album_id,username)"
          + "VALUES (?, ?, ?, ?,?);", Statement.RETURN_GENERATED_KEYS);

      statement.setString(1,song.getTitle());
      statement.setString(2,song.getLength());
      statement.setString(3,song.getFile_path());
      statement.setInt(4,album.getId());
      statement.setString(5, artist.getName());
      statement0.executeUpdate();
      statement.executeUpdate();
      statement.getGeneratedKeys();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override public void deleteSong(Song song)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("DELETE FROM song WHERE song_id = ?");
      statement.setInt(1, song.getSong_id());
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteSongById(int id)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("DELETE FROM song WHERE song_id = ?");
      statement.setInt(1, id);
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Song getSongById(int id)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("Select * FROM Song where song_id = ?");
      statement.setInt(1, id);
      statement0.execute();
      statement.execute();
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next())
      {
        int id1 = resultSet.getInt("song_id");
        String title = resultSet.getString("title");
        String length = resultSet.getString("length");
        String picture = resultSet.getString("file_path");
        Album albumName = new Album();
        Artist artistName = new Artist();
        PreparedStatement statement2 = connection.prepareStatement("Select * FROM album where album_id = ?");
        int album_id = resultSet.getInt("album_id");
        statement2.setInt(1, album_id);
        ResultSet resultSet2 = statement2.executeQuery();
        if(resultSet2.next())
        {
          albumName = AlbumDAOImpl.getInstance().getAlbumById(album_id);
        }
        PreparedStatement statement3 = connection.prepareStatement("Select * FROM artist where username = ?");
        String username = resultSet.getString("username");
        statement3.setString(1, username);
        ResultSet resultSet3 = statement3.executeQuery();
        if(resultSet3.next())
        {
          artistName = ArtistDAOImpl.getInstance().getArtistByName(username);
        }
        return new Song(id1,title,length,picture,albumName,artistName);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void updateSong(Song song)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("UPDATE album SET song_id = ?, title = ?,  length = ?,"
          + " file_path = ?, album_id = ?, username = ? ");
      statement.setInt(1, song.getSong_id());
      statement.setString(2, song.getTitle());
      statement.setString(3, song.getLength());
      statement.setString(4, song.getFile_path());
      statement.setInt(5, song.getAlbum().getId());
      statement.setString(5, song.getArtist().getName());
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public ArrayList<Song> getSongsFromAlbum(Album album)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("Select * FROM Song where album_id = ?");
      statement.setInt(1, album.getId());
      statement0.execute();
      statement.execute();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Song> songs = new ArrayList<>();
      while(resultSet.next())
      {
        int id = resultSet.getInt("song_id");
        String title = resultSet.getString("title");
        String length = resultSet.getString("length");
        String picture = resultSet.getString("file_path");
        Album albumName = new Album();
        Artist artistName = new Artist();
        PreparedStatement statement2 = connection.prepareStatement("Select * FROM album where album_id = ?");
        int album_id = resultSet.getInt("album_id");
        statement2.setInt(1, album_id);
        ResultSet resultSet2 = statement2.executeQuery();
        if(resultSet2.next())
        {
          albumName = AlbumDAOImpl.getInstance().getAlbumById(album_id);
        }
        PreparedStatement statement3 = connection.prepareStatement("Select * FROM artist where username = ?");
        String username = resultSet.getString("username");
        statement3.setString(1, username);
        ResultSet resultSet3 = statement3.executeQuery();
        if(resultSet3.next())
        {
          artistName = ArtistDAOImpl.getInstance().getArtistByName(username);
        }
        songs.add(new Song(id,title,length,picture,albumName,artistName));
      }
      return songs;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }





}
