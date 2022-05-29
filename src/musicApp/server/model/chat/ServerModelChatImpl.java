package musicApp.server.model.chat;

import musicApp.server.model.chat.log.DefaultLog;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerModelChatImpl implements ServerModelChat
{
  private List<LogEntry> logEntries;
  private DefaultLog defaultLog;
  private PropertyChangeSupport support;

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

  @Override public void sendMessage(Message arg)
  {
    LogEntry logEntry = new LogEntry(arg.getMessage(), arg.getDate(), arg.getTime());
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
