package musicApp.shared;

import musicApp.server.model.domainModel.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Message implements Serializable
{
  private String message;
  private LocalDate date;
  private LocalTime time;
  private User user;


  public Message(User user, String message)
  {
    this.user = user;
    this.message = message;
    this.date = getCurrentDate();
    this.time = getCurrentTime();
  }

  public Message(User user1, LocalDate date, LocalTime time, String text)
  {
    this.user = user1;
    this.message = text;
    this.date = date;
    this.time = time;
  }

  private LocalTime getCurrentTime()
  {
    return LocalTime.now();
  }

  private LocalDate getCurrentDate()
  {
    return LocalDate.now();
  }

  public LocalDate getDate()
  {
    return date;
  }

  public LocalTime getTime()
  {
    return time;
  }

  public String getMessage()
  {
    return message;
  }

  public User getUser()
  {
    return user;
  }

  public String toString()
  {
    return user.getUsername() + ": " + message + " (" + time + " " + date + ")";
  }

}
