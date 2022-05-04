package musicApp.client.model.chat;

import musicApp.database.Users.User;
import musicApp.shared.LogEntry;
import musicApp.util.Subject;

import java.util.List;

public interface ChatManager extends Subject {
    void sendMessage(User user,String messageBody);

    List<LogEntry> getLog();

    int getNumberOfUsers();

}
