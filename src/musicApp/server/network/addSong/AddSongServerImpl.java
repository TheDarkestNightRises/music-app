package musicApp.server.network.addSong;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.AddSongServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AddSongServerImpl implements AddSongServer
{

  private final ServerModel serverModel;

  public AddSongServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
  }

  @Override public ArrayList<Album> getAlbumsOfUser(User user) throws Exception
  {
    return serverModel.getModelAddSong().getAlbumsOfUser(user);
  }

  @Override public void addSong(String title, byte[] songBytes, Album album, User user) throws Exception
  {
    serverModel.getModelAddSong().addSong(title, songBytes, album, user);
  }
}
