package musicApp.shared.networking;

import musicApp.server.model.domainModel.Album;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoveAlbumServer extends Remote
{
  void removeAlbum(Album album) throws RemoteException;
}
