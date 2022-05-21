package musicApp.server.network.createPlaylist;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.CreatePLayListServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CreatePlaylistServerImpl implements CreatePLayListServer
{
  private final ServerModel serverModel;

  public CreatePlaylistServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
    this.serverModel = serverModel;
  }

  @Override public void createPlaylist(String title, String description,
      User user) throws Exception
  {
    serverModel.getServerModelCreatePlaylist().createPlaylist(title, description, user);
  }
}
