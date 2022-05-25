package musicApp.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddAlbumServer extends Remote
{
  String uploadAlbumImage(String username, byte[] toByteArray) throws RemoteException;
}
