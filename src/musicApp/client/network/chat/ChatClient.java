package musicApp.client.network.chat;

import musicApp.shared.LogEntry;
import musicApp.shared.Message;
import musicApp.shared.networking.RMIServer;

import java.util.List;

public interface ChatClient {
    void sendMessage(Message message);

    List<LogEntry> getLog();
}
