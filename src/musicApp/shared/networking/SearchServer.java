package musicApp.shared.networking;

import musicApp.server.model.domainModel.Song;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SearchServer extends Remote {
    ArrayList<Song> fetchSortedList() throws RemoteException;

    void searchSong(String newValue) throws RemoteException;

    void searchAlbum(String search) throws RemoteException;

    void searchProfile(String search) throws RemoteException;
}
