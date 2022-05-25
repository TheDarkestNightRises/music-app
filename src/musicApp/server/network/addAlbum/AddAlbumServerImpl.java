package musicApp.server.network.addAlbum;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.AddAlbumServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddAlbumServerImpl implements AddAlbumServer
{
  private final ServerModel serverModel;

  public AddAlbumServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
  }

  @Override public String uploadAlbumImage(String username, byte[] toByteArray)
  {
    String path = serverModel.getModelAddAlbums().uploadAlbumPicture(username, toByteArray);
    return path;
  }

  @Override public Artist getArtist(User user)
  {
    return serverModel.getModelAddAlbums().getArtist(user);
  }
}
