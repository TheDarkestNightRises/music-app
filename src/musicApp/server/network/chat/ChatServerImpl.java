package musicApp.server.network.chat;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.chat.ServerModelChat;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;
import musicApp.shared.networking.ChatServer;
import musicApp.shared.networking.ClientCallBack;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class ChatServerImpl implements ChatServer {

    private final ServerModelChat serverModelChat;
    private final ServerModelLogin serverModelLogin;
    private List<ClientCallBack> clientList;

    public ChatServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelChat = serverModelFactory.getModelChat();
        this.serverModelLogin = serverModelFactory.getModelLogin();
        this.clientList = new ArrayList<>();
    }

    @Override
    public List<LogEntry> getLog() {
        return serverModelChat.getLog();
    }

    @Override
    public void sendMessage(Message message) {
        updateClients(message);
        serverModelChat.sendMessage(message);
    }

    @Override
    public int getNumberOfUsers() {
        return serverModelLogin.getNumberOfUsers();
    }

    public void updateClients(Message message) {
        for (ClientCallBack client : clientList) {
            try {
                client.updateChat(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerClientToBroadcast(ClientCallBack client) {
        clientList.add(client);
    }
}
