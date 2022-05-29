package musicApp.server.network.addToPlaylist;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.addToPlaylist.ServerModelAddToPlaylist;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.AddToPlaylistServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddToPlaylistServerImpl implements AddToPlaylistServer
{


  private final ServerModelAddToPlaylist serverModelAddToPlaylist;

  public AddToPlaylistServerImpl(ServerModelFactory serverModelFactory) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModelAddToPlaylist = serverModelFactory.getModelAddToPlaylist();
  }

  @Override public void addToPlaylist(User user, Playlist playlist, Song currentSong) throws Exception
  {
    serverModelAddToPlaylist.addToPlaylist(user, playlist, currentSong);
  }
}
