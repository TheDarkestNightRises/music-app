package musicApp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory
{

  // -------------------------------- EMANUEL ------------------------------------------------------------

//  private static final String URL = "jdbc:postgresql://localhost/music_app";
//  private static final String USERNAME = "postgres";
//  private static final String PASSWORD = "htmlhacker";

  // -------------------------------- ANDREI ------------------------------------------------------------
//      private static final String URL = "jdbc:postgresql://localhost:5432/music";
//      private static final String USERNAME = "postgres";
//      private static final String PASSWORD = "pufulet9009";

   //-------------------------------- COSMIN ------------------------------------------------------------
      private static final String URL = "jdbc:postgresql://localhost:5432/music";
      private static final String USERNAME = "postgres";
      private static final String PASSWORD = "Cosmin";

  private static Connection connection;
  private static ConnectionFactory connectionFactory = null;

  private ConnectionFactory()
  {
  }

  public Connection getConnection() throws SQLException
  {
    if (connection == null)
    {
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    return connection;
  }

  public static ConnectionFactory getInstance()
  {
    if (connectionFactory == null)
    {
      connectionFactory = new ConnectionFactory();
    }
    return connectionFactory;
  }

  public void close()
  {
    try
    {
      connection.close();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

}
