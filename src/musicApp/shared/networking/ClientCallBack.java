package musicApp.shared.networking;

import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {
    // -----------UPDATE CLIENT ASYNC----------------
    void updateLog(LogEntry log) throws RemoteException;

    void updateChat(Message message) throws RemoteException;

    void updateUserNumber(int newValue) throws RemoteException;
}
