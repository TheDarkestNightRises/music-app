package musicApp.server.network.deleteSong;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.DeleteSongServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DeleteSongServerImpl implements DeleteSongServer
{
  private ServerModel serverModel;

  public DeleteSongServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
    this.serverModel = serverModel;
  }

  @Override public ArrayList<Song> getSongsOfUser(User user) throws Exception
  {
    return serverModel.getModelDeleteSong().getSongsOfUser(user);
  }

  @Override public void deleteSong(Song song) throws Exception
  {
    serverModel.getModelDeleteSong().deleteSong(song);
  }
}
