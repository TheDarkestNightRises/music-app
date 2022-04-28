package musicApp.shared.networking;

import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatServer extends Remote {

    //------------Chat-------------------
    List<LogEntry> getLog() throws RemoteException;

    void sendMessage(Message message) throws RemoteException;

    int getNumberOfUsers() throws RemoteException;

    void updateClients(Message message) throws RemoteException;

    void registerClientToBroadcast(ClientCallBack client) throws RemoteException;
}
