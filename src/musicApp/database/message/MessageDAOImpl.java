package musicApp.database.message;

import musicApp.database.ConnectionFactory;
import musicApp.database.follow.FollowDAO;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.User;
import musicApp.shared.Message;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class MessageDAOImpl implements MessageDAO
{

  private static MessageDAOImpl instance;

  public MessageDAOImpl() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized MessageDAOImpl getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new MessageDAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    Connection conn;
    conn = ConnectionFactory.getInstance().getConnection();
    return conn;
  }

  @Override public ArrayList<Message> getLast40Messages()
  {
    try
    {
      PreparedStatement statement0 = getConnection().prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM message ORDER BY sent_on DESC LIMIT 50");
      statement0.executeUpdate();
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Message> list = new ArrayList<>();
      while (resultSet.next())
      {
        String text = resultSet.getString("text");
        Timestamp timestamp = resultSet.getTimestamp("sent_on");
        LocalDate date = LocalDate.of(timestamp.getYear(), timestamp.getMonth(), timestamp.getDay());
        LocalTime time = LocalTime.of(timestamp.getHours(), timestamp.getMinutes(), timestamp.getSeconds(),
            timestamp.getNanos());
        String name = resultSet.getString("username");
        User user1 = UsersDAOImpl.getInstance().getUserByName(name);
        Message message = new Message(user1, date, time, text);
        list.add(message);

      }
      Collections.reverse(list);
      return list;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void addMessage(User user, Message message)
  {
    try
    {
      Connection connection = getConnection();
      PreparedStatement statement0 = connection.prepareStatement("SET SCHEMA 'music_app'");
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO message(text, sent_on, username)" + "VALUES (?, ?, ?);");
      statement.setString(1, message.getMessage());
      Timestamp timestamp = new Timestamp(message.getDate().getYear(), message.getDate().getMonthValue(),
          message.getDate().getDayOfMonth(), message.getTime().getHour(), message.getTime().getMinute(),
          message.getTime().getSecond(), message.getTime().getNano());
      statement.setTimestamp(2, timestamp);
      statement.setString(3, user.getUsername());
      statement0.executeUpdate();
      statement.executeUpdate();
      statement.getGeneratedKeys();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
