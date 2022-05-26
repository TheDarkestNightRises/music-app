package musicApp.shared.networking;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ProfileServer extends Remote {
    ArrayList<Playlist> fetchPlaylistsForUser(User user) throws RemoteException;

    ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) throws RemoteException;

    byte[] fetchProfilePicture(String profile_picture) throws RemoteException;

    ArrayList<Album> fetchArtistAlbums(User user) throws RemoteException;

    boolean isArtist(User user) throws RemoteException;

    void follow(User user0, User user) throws RemoteException;

    void unfollow(User user0, User user) throws RemoteException;
}
