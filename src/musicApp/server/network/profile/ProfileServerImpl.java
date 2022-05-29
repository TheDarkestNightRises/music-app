package musicApp.server.network.profile;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.profile.ServerModelProfile;
import musicApp.shared.networking.ProfileServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ProfileServerImpl implements ProfileServer
{
  private final ServerModelProfile serverModelProfile;

  public ProfileServerImpl(ServerModelFactory serverModelFactory) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModelProfile = serverModelFactory.getModelProfile();
  }

  @Override public ArrayList<Playlist> fetchPlaylistsForUser(User user)
  {
    return serverModelProfile.fetchPlaylistsForUser(user);
  }

  @Override public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist)
  {
    return serverModelProfile.fetchSongsForPlaylist(playlist);
  }

  @Override public byte[] fetchProfilePicture(String profile_picture) throws RemoteException
  {
    return serverModelProfile.fetchProfilePicture(profile_picture);
  }

  @Override public ArrayList<Album> fetchArtistAlbums(User user) throws RemoteException
  {
    return serverModelProfile.fetchArtistAlbums(user);
  }

  @Override public boolean isArtist(User user) throws RemoteException
  {
    return serverModelProfile.isArtist(user);
  }

  @Override public void follow(User user0, User user) throws RemoteException
  {
    serverModelProfile.follow(user0, user);
  }

  @Override public void unfollow(User user0, User user) throws RemoteException
  {
    serverModelProfile.unfollow(user0, user);
  }
}
