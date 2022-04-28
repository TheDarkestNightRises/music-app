package musicApp.server.model.chat;

import musicApp.shared.LogEntry;
import musicApp.shared.Message;
import musicApp.util.Subject;

import java.util.List;

public interface ServerModelChat extends Subject {
    //--------Chat-------
    List<LogEntry> getLog();
    void sendMessage(Message arg);
}
