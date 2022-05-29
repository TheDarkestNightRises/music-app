package musicApp.client.model.chat;

import musicApp.server.model.domainModel.User;
import musicApp.client.network.Client;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatManagerImplementation implements ChatManager
{

  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;

  public ChatManagerImplementation(Client client)
  {
    this.client = client;
    client.addListener("NewLogEntry", this::onNewLogEntry);
    client.addListener("MessageAdded", this::onNewMessage);
  }

  private void onNewMessage(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  private void onNewLogEntry(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  @Override public List<LogEntry> getLog()
  {
    return client.getChatClient().getLog();
  }

  @Override public int getNumberOfUsers()
  {
    return client.getLoginClient().getNumberOfUsers();
  }

  @Override public void sendMessage(User user,String messageBody)
  {
   Message message = new Message(user,messageBody);
   client.getChatClient().sendMessage(message);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
