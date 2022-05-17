package musicApp.shared.networking;

import musicApp.server.model.domainModel.Song;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SearchServer extends Remote {
    ArrayList<Song> fetchSortedList() throws RemoteException;

    void search(String newValue) throws RemoteException;
}
