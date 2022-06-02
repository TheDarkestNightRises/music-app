package musicApp.server.model.chat;

import musicApp.server.model.chat.log.DefaultLog;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Chat model
 */
public class ServerModelChatImpl implements ServerModelChat
{
  private List<LogEntry> logEntries;
  private DefaultLog defaultLog;
  private PropertyChangeSupport support;

  /**
   * This is the server model constructor. It initializes the log entry and remembers what the user
   * messaged.
   */
  public ServerModelChatImpl()
  {
    support = new PropertyChangeSupport(this);
    logEntries = new ArrayList<>();
    defaultLog = DefaultLog.getInstance();
  }

  @Override public List<LogEntry> getLog()
  {
    return new ArrayList<>(logEntries);
  }

  /**
   * This will send the message to all the users make a log of it in a file, and remebering it for the
   * log tabel. This method is
   * @param message containing text,date,tiime
   */
  @Override public void sendMessage(Message message)
  {
    LogEntry logEntry = new LogEntry(message.getMessage(), message.getDate(), message.getTime());
    try
    {
      defaultLog.log(logEntry.toString());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    logEntries.add(logEntry);
    support.firePropertyChange("NewLogEntry", null, logEntry);
  }

  @Override public void addListener(String eventName, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
