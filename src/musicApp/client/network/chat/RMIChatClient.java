package musicApp.client.network.chat;

import musicApp.shared.LogEntry;
import musicApp.shared.Message;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.List;

public class RMIChatClient implements ChatClient{
    private RMIServer server;

    public RMIChatClient(RMIServer server) {
        this.server = server;
    }

    @Override
    public List<LogEntry> getLog() {
        try {
            return server.getChatServer().getLog();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Cant connect to server");
        }
    }

    @Override
    public void sendMessage(Message message)  {
        try {
            server.getChatServer().sendMessage(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
