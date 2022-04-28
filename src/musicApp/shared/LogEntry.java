package musicApp.shared;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogEntry implements Serializable
{
  private String text;
  private LocalDate date;
  private LocalTime time;

  public LogEntry(String text, LocalDate date, LocalTime time)
  {
    this.text = text;
    this.date = date;
    this.time = time;
  }

  public String getText()
  {
    return text;
  }

  public LocalDate getDate()
  {
    return date;
  }

  public LocalTime getTime()
  {
    return time;
  }

  @Override
  public String toString() {
    return "LogEntry{" +
            "text='" + text + '\'' +
            ", date=" + date +
            ", time=" + time +
            '}';
  }
}
