package musicApp.database.Users;

import java.sql.*;

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
    return DriverManager.getConnection(URL,USERNAME,PASSWORD);
  }

  public User createUser(String username, String password, String email)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement("INSERT INTO User_(username, password_, email, nickname, profile_picture_path, description) "
           + "VALUES (?, ?, ?, ?, ?, ?);");
      statement.setString(1,username);
      statement.setString(2,password);
      statement.setString(3,email);
      statement.setString(4,"");
      statement.setString(5,"");
      statement.setString(6,"");
      statement0.executeUpdate();
      statement.executeUpdate();
      return new User(username,password,email,"","","");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override public boolean accountExists(String username, String password)
      throws SQLException
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement0 = connection.prepareStatement(
          "SET SCHEMA 'music_app'");
      statement0.executeUpdate();
      PreparedStatement statement = connection.prepareStatement(
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
  }

}









