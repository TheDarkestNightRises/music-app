package musicApp.database.follow;

import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.artist.Artist;
import musicApp.database.users.User;
import musicApp.database.users.UsersDAOImpl;

import java.sql.*;
import java.util.ArrayList;

public class FollowDAOImpl implements FollowDAO
{

  private static FollowDAOImpl instance;
  public static String URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/viinvdnw";
  public static String USERNAME = "viinvdnw";
  public static String PASSWORD = "RYTBFOCvnjTJFnAoOA-XeuvHE7sdLyV-";

  public FollowDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized FollowDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new FollowDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(URL,USERNAME,PASSWORD);
  }


  @Override public ArrayList<User> getFollowList(User user)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM followers JOIN user_ ON followed = username WHERE followed = ?" );
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      statement.setString(1,user.getUsername());
      ArrayList<User> list = new ArrayList<>();
      while(resultSet.next())
      {
        String name = resultSet.getString("follower");
        User user1 = UsersDAOImpl.getInstance().getUserByName(name);
//        String username = resultSet.getString(user1.getUsername());
//        String password = resultSet.getString(user1.getPassword());
//        String email = resultSet.getString(user1.getEmail());
//        String nick = resultSet.getString(user1.getNickname());
//        String picture = resultSet.getString(user1.getProfile_picture());
//        String description = resultSet.getString(user1.getDescription());
//        User user2 = new User(username,password,email,nick,picture,description);
        list.add(user1);
      }
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void Follow(User follower, User followed)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("INSERT INTO followers(follower,followed) "
          + "VALUES (?, ?);");

      statement.setString(1,follower.getUsername());
      statement.setString(2,followed.getUsername());

      statement0.executeUpdate();
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override public void Unfollow(User user1, User user2)
  {

  }
}
