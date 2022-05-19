package musicApp.shared.networking;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MainMenuServer extends Remote {
    ArrayList<Song> fetchRandomSongs() throws RemoteException;

    ArrayList<Song> fetchLastSongs() throws RemoteException;

    ArrayList<Album> fetchRandomAlbums() throws RemoteException;
}
