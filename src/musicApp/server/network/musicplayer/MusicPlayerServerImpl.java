package musicApp.server.network.musicplayer;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.shared.networking.MusicPlayerServer;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MusicPlayerServerImpl implements MusicPlayerServer
{
  private final ServerModelMusic serverModelMusic;

  public MusicPlayerServerImpl(ServerModelFactory serverModelFactory) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModelMusic = serverModelFactory.getModelMusic();
  }

  @Override public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist)
  {
    return serverModelMusic.getCurrentPlaylistFiles(playlist);
  }

  @Override public byte[] fetchAlbumCover(String picturePath)
  {
    return serverModelMusic.fetchAlbumCover(picturePath);
  }

  @Override public void addToLikedSongs(User user, Song song) throws RemoteException
  {
    serverModelMusic.addToLikedSongs(user, song);
  }

  @Override public void removeToLikedSongs(User user, Song song) throws RemoteException
  {
    serverModelMusic.removeToLikedSongs(user, song);
  }
}
