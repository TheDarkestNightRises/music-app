package musicApp.shared.networking;

import musicApp.server.model.domainModel.Song;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClientCallBack extends Remote {
    // -----------UPDATE CLIENT ASYNC----------------
    void updateLog(LogEntry log) throws RemoteException;

    void updateChat(Message message) throws RemoteException;

    void updateUserNumber(int newValue) throws RemoteException;

    void updateSearchResult(ArrayList<Song> songsSearchResult) throws RemoteException;
}
