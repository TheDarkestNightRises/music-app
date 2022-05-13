package musicApp.shared.networking;

import musicApp.server.model.Playlist;
import musicApp.server.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ProfileServer extends Remote {
    ArrayList<Playlist> fetchPlaylistsForUser(User user) throws RemoteException;
}
