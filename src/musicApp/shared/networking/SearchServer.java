package musicApp.shared.networking;

import javafx.collections.transformation.SortedList;
import musicApp.server.model.domainModel.Song;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SearchServer extends Remote {
    SortedList<Song> fetchSortedList() throws RemoteException;
}
