package musicApp.client.network.profile;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.util.ArrayList;

public interface ProfileClient
{

  ArrayList<Playlist> fetchPlaylistsForUser(User user);

  ArrayList<Song> fetchSongsForPlaylist(Playlist playlist);

  byte[] fetchProfilePicture(String profile_picture);

  ArrayList<Album> fetchArtistAlbums(User user);

  boolean isArtist(User user);

  void follow(User user0, User user);

  void unfollow(User user0, User user);
}
