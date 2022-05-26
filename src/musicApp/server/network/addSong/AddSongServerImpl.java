package musicApp.server.network.addSong;

import musicApp.server.model.ServerModel;
import musicApp.shared.networking.AddSongServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddSongServerImpl implements AddSongServer
{

  private final ServerModel serverModel;

  public AddSongServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
  }
}
