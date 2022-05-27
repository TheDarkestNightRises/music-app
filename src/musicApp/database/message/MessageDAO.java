package musicApp.database.message;

import musicApp.server.model.domainModel.User;
import musicApp.shared.Message;

import java.util.ArrayList;

public interface MessageDAO
{

  ArrayList<Message> getLast40Messages();
  void addMessage(User user, Message message);
}
