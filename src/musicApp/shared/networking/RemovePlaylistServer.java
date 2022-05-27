package musicApp.shared.networking;

import musicApp.server.model.domainModel.Playlist;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemovePlaylistServer extends Remote
{
  void removePlaylist(Playlist playlist) throws RemoteException;
}
