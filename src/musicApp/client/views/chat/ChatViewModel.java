package musicApp.client.views.chat;

import musicApp.shared.Message;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;


public class ChatViewModel
{
  private MainModel mainModel;
  private SimpleListProperty<String> chat;
  private StringProperty messageBody;
  private StringProperty user;
  private StringProperty onlineUsers;

  public ChatViewModel(MainModel mainModel)
  {
    this.mainModel = mainModel;
    this.chat = new SimpleListProperty<>(FXCollections.observableArrayList());
    this.messageBody = new SimpleStringProperty("");
    this.user = new SimpleStringProperty(this.mainModel.getLogInManager().getUserName());
    this.onlineUsers = new SimpleStringProperty("");
    this.mainModel.getChatManager().addListener("MessageAdded", this::updateChat);
    this.mainModel.getLogInManager().addListener("OnNewUserEntry", this::onNewUserEntry);
  }

  /**
   *
   * @param propertyChangeEvent Once a user enters the chat it updates the number of online users
   */
  private void onNewUserEntry(PropertyChangeEvent propertyChangeEvent)
  {
    int number = (int) propertyChangeEvent.getNewValue();
    Platform.runLater(() -> onlineUsers.set("Online users: " + number));
  }

  /**
   *
   * @param propertyChangeEvent The chat it's updated automatically after a user sends a message
   */
  private void updateChat(PropertyChangeEvent propertyChangeEvent)
  {
    Message message = (Message) propertyChangeEvent.getNewValue();
    Platform.runLater(() -> chat.add(String.valueOf(message)));
  }

  public void send()
  {
    mainModel.getChatManager().sendMessage(mainModel.getLogInManager().getUser(),messageBody.get());
    messageBody.set("");
  }

  public void bindChat(ObjectProperty<ObservableList<String>> property)
  {
    property.bind(chat);
  }

  public void bindMessage(StringProperty property)
  {
    property.bindBidirectional(messageBody);
  }

  public void bindUser(StringProperty property)
  {
    property.bind(user);
  }


  public void fetchNumberOfOnlineUsers()
  {
    onlineUsers.set("Online users: " + mainModel.getChatManager().getNumberOfUsers());
  }
}
