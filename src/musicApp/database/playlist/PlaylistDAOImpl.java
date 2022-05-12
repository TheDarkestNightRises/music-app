package musicApp.database.playlist;

import musicApp.database.artist.ArtistDAOImpl;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.*;

import java.sql.*;
import java.util.ArrayList;

public class PlaylistDAOImpl implements PlaylistDAO
{
  private static PlaylistDAOImpl instance;
  public static String URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/viinvdnw";
  public static String USERNAME = "viinvdnw";
  public static String PASSWORD = "RYTBFOCvnjTJFnAoOA-XeuvHE7sdLyV-";

  public PlaylistDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized PlaylistDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new PlaylistDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
  }

  @Override public void createPlayList(String title, String description, String picture, User user)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO playlist(title, description, picture_path, username) " + "VALUES (?, ?, ?, ?);",
          Statement.RETURN_GENERATED_KEYS);

      statement.setString(1, title);
      statement.setString(2, description);
      statement.setString(3, picture);
      statement.setString(4, user.getUsername());
      statement0.executeUpdate();
      statement.executeUpdate();
      statement.getGeneratedKeys();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deletePlayList(Playlist playlist)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("DELETE FROM playlist WHERE playlist_id = ?");
      statement.setInt(1, playlist.getPlaylist_id());
      statement0.executeUpdate();
      statement.executeUpdate();
      PreparedStatement statement2 = connection.prepareStatement("DELETE FROM playlist_song_pair WHERE playlist_id = ?");
      statement2.setInt(1,playlist.getPlaylist_id());
      statement2.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override public void deletePlayListById(int id)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("DELETE FROM playlist WHERE playlist_id = ?");
      statement.setInt(1, id);
      statement0.executeUpdate();
      statement.executeUpdate();
      PreparedStatement statement2 = connection.prepareStatement("DELETE FROM playlist_song_pair WHERE playlist_id = ?");
      statement2.setInt(1,id);
      statement2.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override public void updatePlaylist(Playlist playlist, User user)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE playlist SET  title = ?, description = ?, picture_path = ?, username= ? where playlist_id = ? ");
      statement.setString(1, playlist.getTitle());
      statement.setString(2, playlist.getDescription());
      statement.setString(3, playlist.getPicture_name());
      statement.setString(4, user.getUsername());
      statement.setInt(5, playlist.getPlaylist_id());
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void insertSongIntoPlaylist(Playlist playlist, Song song)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO playlist_song_pair(playlist_id, song_id) " + "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);

      statement.setInt(1, playlist.getPlaylist_id());
      statement.setInt(2, song.getSong_id());
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public ArrayList<Song> getAllSongsFromPlayList(Playlist playlist)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM playlist_song_pair where playlist_id = ?");
      statement.setInt(1, playlist.getPlaylist_id());
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Song> songs = new ArrayList<>();
      while (resultSet.next())
      {
        int song_id = resultSet.getInt("song_id");
        Song song = SongDAOImpl.getInstance().getSongById(song_id);
        songs.add(song);
      }
      return songs;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
