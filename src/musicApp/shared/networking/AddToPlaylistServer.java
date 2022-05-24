package musicApp.shared.networking;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddToPlaylistServer extends Remote
{
  void addToPlaylist(User user, Playlist playlist, Song currentSong)
      throws Exception;
}
