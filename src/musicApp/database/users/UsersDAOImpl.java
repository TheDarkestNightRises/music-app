package musicApp.database.users;

import musicApp.database.ConnectionFactory;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.sql.*;
import java.util.ArrayList;

public class UsersDAOImpl implements UsersDAO
{
  private static UsersDAOImpl instance;
  private Connection connection;

  public UsersDAOImpl() throws SQLException
  {
    this.connection = getConnection();
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
    Connection conn;
    conn = ConnectionFactory.getInstance().getConnection();
    return conn;
  }

  public User createUser(String username, String password, String email)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO User_(username, password_, email, nickname, profile_picture_path, description) "
              + "VALUES (?, ?, ?, ?, ?, ?);");
      statement.setString(1, username);
      statement.setString(2, password);
      statement.setString(3, email);
      statement.setString(4, "");
      statement.setString(5, "");
      statement.setString(6, "");
      statement0.executeUpdate();
      statement.executeUpdate();
      return new User(username, password, email, "", "", "", null);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Sql error " + e);
    }
  }

  @Override public boolean accountExists(String username, String password) throws SQLException
  {
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      statement0.executeUpdate();
      PreparedStatement statement = getConnection().prepareStatement(
          "SELECT * FROM User_ WHERE username = ? AND password_ = ?");
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
    finally
    {

    }
  }

  @Override public boolean usernameExists(String username) throws SQLException
  {
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      statement0.executeUpdate();
      PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM User_ WHERE username = ? ");
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
    finally
    {

    }
  }

  @Override public User getUserByName(String username)
  {
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM User_ WHERE username = ?");
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
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = getConnection().prepareStatement(
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
        PreparedStatement statement2 = getConnection().prepareStatement(
            "Select * FROM playlist_song_pair where playlist_id = ?");
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

  @Override public Playlist getPlaylistIdFromUserByName(User user, String title)
  {
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = getConnection().prepareStatement(
          "SELECT * FROM playlist WHERE username = ? AND title = ?");
      statement.setString(1, user.getUsername());
      statement.setString(2, title);
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        int id = resultSet.getInt("playlist_id");
        return new Playlist(id, title, "", "", new ArrayList<>());
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
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM playlist where username = ?");
      statement.setString(1, user.getUsername());
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Playlist> playlists = new ArrayList<>();
      while (resultSet.next())
      {
        int id1 = resultSet.getInt("playlist_id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        String picture = resultSet.getString("picture_path");
        ArrayList<Song> songs = new ArrayList<>();
        PreparedStatement statement2 = getConnection().prepareStatement(
            "Select * FROM playlist_song_pair where playlist_id = ?");
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

  @Override public void updateUserInfo(String username, String password, String email, String nickname,
      String description)
  {
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = getConnection().prepareStatement(
          "UPDATE user_ SET password_ = ?, email = ?, nickname = ?, description  = ? WHERE username = ?");
      statement.setString(1, password);
      statement.setString(2, email);
      statement.setString(3, nickname);
      statement.setString(4, description);
      statement.setString(5, username);
      statement0.executeUpdate();
      statement.executeUpdate();

    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Database error");
    }
  }

  @Override public boolean PlaylistExists(User user, String playlistName)
  {
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = getConnection().prepareStatement(
          "SELECT * FROM playlist WHERE username = ? AND title = ?");
      statement.setString(1, user.getUsername());
      statement.setString(2, playlistName);
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        return true;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  @Override public void uploadPicture(String username, String pictureName)
  {
    try
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE user_ SET profile_picture_path = ? WHERE username = ?");
      statement.setString(1, pictureName);
      statement.setString(2, username);
      statement0.executeUpdate();
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Database error");
    }
  }

  @Override public ArrayList<User> getAllUsers()
  {
    try
    {
      ArrayList<User> users = new ArrayList<>();
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_");
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password_");
        String email = resultSet.getString("email");
        String nickname = resultSet.getString("nickname");
        String picture = resultSet.getString("profile_picture_path");
        String description = resultSet.getString("description");
        User user = new User(username, password, email, description, picture, nickname);
        users.add(user);
      }
      return users;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Database error");
    }
  }
}












