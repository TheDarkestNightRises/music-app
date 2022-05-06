package musicApp.database.follow;

import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
