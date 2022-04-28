package musicApp.server.network.chat;

import musicApp.server.model.ServerModel;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;
import musicApp.shared.networking.ChatServer;
import musicApp.shared.networking.ClientCallBack;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServerImpl implements ChatServer {
    private final ServerModel serverModel;
    private List<ClientCallBack> clientList;

    public ChatServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.serverModel = serverModel;
        this.clientList = new ArrayList<>();
    }

    @Override
    public List<LogEntry> getLog() {
        return serverModel.getModelChat().getLog();
    }
    @Override
    public void sendMessage(Message message) {
        updateClients(message);
        serverModel.getModelChat().sendMessage(message);
    }
    @Override
    public int getNumberOfUsers() {
        return serverModel.getModelLogin().getNumberOfUsers();
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
