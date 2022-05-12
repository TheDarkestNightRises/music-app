package musicApp.database.users;

import musicApp.database.artist.ArtistDAOImpl;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.*;

import java.sql.*;
import java.util.ArrayList;

public class UsersDAOImpl implements UsersDAO
{
  private static UsersDAOImpl instance;
  public static String URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/viinvdnw";
  public static String USERNAME = "viinvdnw";
  public static String PASSWORD = "RYTBFOCvnjTJFnAoOA-XeuvHE7sdLyV-";

  public UsersDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized UsersDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new UsersDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
  }

  public User createUser(String username, String password, String email)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO User_(username, password_, email, nickname, profile_picture_path, description) " + "VALUES (?, ?, ?, ?, ?, ?);");
      statement.setString(1, username);
      statement.setString(2, password);
      statement.setString(3, email);
      statement.setString(4, "");
      statement.setString(5, "");
      statement.setString(6, "");
      statement0.executeUpdate();
      statement.executeUpdate();
      return new User(username, password, email, "", "", "",null);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public boolean accountExists(String username, String password) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      statement0.executeUpdate();
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM User_ WHERE username = ? AND password_ = ?");
      statement.setString(1, username);
      statement.setString(2, password);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        return true;
      }
      else
      {
        return false;
      }
    }
  }

  @Override public boolean usernameExists(String username) throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      statement0.executeUpdate();
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM User_ WHERE username = ? ");
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        return true;
      }
      else
      {
        return false;
      }
    }
  }

  @Override public User getUserByName(String username)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM User_ WHERE username = ?");
      ArrayList<Playlist> playlists = new ArrayList<>();
      statement.setString(1, username);
      statement0.execute();
      statement.execute();
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String name = resultSet.getString("username");
        String password = resultSet.getString("password_");
        String email = resultSet.getString("email");
        String nick = resultSet.getString("nickname");
        String picture = resultSet.getString("profile_picture_path");
        String description = resultSet.getString("description");
        User user = new User(name, password, email, nick, picture, description, playlists);
        return user;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Playlist getPlaylistFromUserById(User user, int id)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM playlist where username = ? and playlist_id = ?");
      statement.setString(1, user.getUsername());
      statement.setInt(2, id);
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        int id1 = resultSet.getInt("playlist_id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        String picture = resultSet.getString("picture_path");
        ArrayList<Song> songs = new ArrayList<>();
        PreparedStatement statement2 = connection.prepareStatement("Select * FROM playlist_song_pair where playlist_id = ?");
        statement2.setInt(1, id1);
        ResultSet resultSet2 = statement2.executeQuery();
        while (resultSet2.next())
        {
          int song_id = resultSet2.getInt("song_id");
          songs.add(SongDAOImpl.getInstance().getSongById(song_id));
        }
        return new Playlist(id, title, description, picture, songs);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public ArrayList<Playlist> getAllPlaylistsFromUser(User user)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM playlist where username = ?");
      statement.setString(1, user.getUsername());
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Playlist> playlists= new ArrayList<>();
      while (resultSet.next())
      {
        int id1 = resultSet.getInt("playlist_id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        String picture = resultSet.getString("picture_path");
        ArrayList<Song> songs = new ArrayList<>();
        PreparedStatement statement2 = connection.prepareStatement("Select * FROM playlist_song_pair where playlist_id = ?");
        statement2.setInt(1, id1);
        ResultSet resultSet2 = statement2.executeQuery();
        while (resultSet2.next())
        {
          int song_id = resultSet2.getInt("song_id");
          songs.add(SongDAOImpl.getInstance().getSongById(song_id));
        }
        Playlist playlist = new Playlist(id1, title, description, picture, songs);
        playlists.add(playlist);
      }
      return playlists;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}












