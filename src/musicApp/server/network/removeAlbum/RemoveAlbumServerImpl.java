package musicApp.server.network.removeAlbum;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Album;
import musicApp.shared.networking.RemoveAlbumServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoveAlbumServerImpl implements RemoveAlbumServer
{
  private final ServerModel serverModel;

  public RemoveAlbumServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
  }

  @Override public void removeAlbum(Album album) throws RemoteException
  {
    serverModel.getModelRemoveAlbum().removeAlbum(album);
  }
}
