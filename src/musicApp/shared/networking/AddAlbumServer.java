package musicApp.shared.networking;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddAlbumServer extends Remote
{
  String uploadAlbumImage(String username, byte[] toByteArray) throws RemoteException;
  Artist getArtist(User user) throws RemoteException;
  void createAlbum(String title, int year, String uploaded, Artist artist) throws RemoteException;
}
