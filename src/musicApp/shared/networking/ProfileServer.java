package musicApp.shared.networking;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ProfileServer extends Remote {
    ArrayList<Playlist> fetchPlaylistsForUser(User user) throws RemoteException;

    ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) throws RemoteException;
}
