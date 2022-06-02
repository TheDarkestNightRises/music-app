package musicApp.client.views.chat;

import musicApp.client.model.chat.ChatManager;
import musicApp.client.model.login.LogInManager;
import musicApp.shared.Message;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;

/**
 * This is the chat view model responsible for all the UI logic
 */
public class ChatViewModel
{
  private LogInManager loginManager;
  private ChatManager chatManager;
  private SimpleListProperty<String> chat;
  private StringProperty messageBody;
  private StringProperty user;
  private StringProperty onlineUsers;

  /**
   * This is the constructors for the view model. The view model will listen to 2 changes,if a new
   * message was sent
    * @param loginManager to get the current user
   * @param chatManager to use the models method
   */
  public ChatViewModel(LogInManager loginManager, ChatManager chatManager) {
    this.loginManager = loginManager;
    this.chatManager = chatManager;
    this.chat = new SimpleListProperty<>(FXCollections.observableArrayList());
    this.messageBody = new SimpleStringProperty("");
    this.user = new SimpleStringProperty(loginManager.getUserName());
    this.onlineUsers = new SimpleStringProperty("");
    chatManager.addListener("MessageAdded", this::updateChat);
    loginManager.addListener("OnNewUserEntry", this::onNewUserEntry);
  }

  /**
   * Once a user enters the chat it updates the number of online users
   * @param propertyChangeEvent int number of users
   */
  private void onNewUserEntry(PropertyChangeEvent propertyChangeEvent)
  {
    int number = (int) propertyChangeEvent.getNewValue();
    Platform.runLater(() -> onlineUsers.set("Online users: " + number));
  }

  /**
   * The chat it's updated automatically after a user sends a message
   * @param propertyChangeEvent message
   */
  private void updateChat(PropertyChangeEvent propertyChangeEvent)
  {
    Message message = (Message) propertyChangeEvent.getNewValue();
    Platform.runLater(() -> chat.add(String.valueOf(message)));
  }

  /**
   * This method will get the user input and send the message delegating to the model
   */
  public void send()
  {
    chatManager.sendMessage(loginManager.getUser(),messageBody.get());
    messageBody.set("");
  }

  /**
   * This will bind the chat UI to this property
   * @param property
   */
  public void bindChat(ObjectProperty<ObservableList<String>> property)
  {
    property.bind(chat);
  }

  /**
   * Bindings necessary for MVVM
   * @param property
   */
  public void bindMessage(StringProperty property)
  {
    property.bindBidirectional(messageBody);
  }

  /**
   * Bindings necessary for MVVM
   * @param property
   */
  public void bindUser(StringProperty property)
  {
    property.bind(user);
  }

  /**
   * This will fetch the number of user online
   */
  public void fetchNumberOfOnlineUsers()
  {
    onlineUsers.set("Online users: " + chatManager.getNumberOfUsers());
  }
}
