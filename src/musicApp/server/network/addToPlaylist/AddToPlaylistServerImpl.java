package musicApp.server.network.addToPlaylist;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.AddToPlaylistServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddToPlaylistServerImpl implements AddToPlaylistServer
{
  private final ServerModel serverModel;
  public AddToPlaylistServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
    this.serverModel = serverModel;
  }

  @Override public void addToPlaylist(User user, Playlist playlist,
      Song currentSong) throws Exception
  {
    serverModel.getModelAddToPlaylist().addToPlaylist(user, playlist, currentSong);
  }
}
