package musicApp.server.network.removePlaylist;

import musicApp.client.network.removePlaylist.RemovePlaylistClient;
import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Playlist;
import musicApp.shared.networking.RemovePlaylistServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemovePlaylistServerImpl implements RemovePlaylistServer
{
  private final ServerModel serverModel;

  public RemovePlaylistServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
  }


  @Override public void removePlaylist(Playlist playlist)
  {
    serverModel.getModelRemovePlaylist().removeAlbum(playlist);
  }
}
