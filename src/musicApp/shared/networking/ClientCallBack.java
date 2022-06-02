package musicApp.shared.networking;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * The client call back is used by the server to call methods on it to call the support to fire
 */
public interface ClientCallBack extends Remote {
    // -----------UPDATE CLIENT ASYNC----------------
    void updateLog(LogEntry log) throws RemoteException;

    void updateChat(Message message) throws RemoteException;

    void updateUserNumber(int newValue) throws RemoteException;

    void updateSongSearchResult(ArrayList<Song> songsSearchResult) throws RemoteException;

    void updateAlbumSearchResult(ArrayList<Album> albumsSearchResult) throws RemoteException;

    void updateProfileSearchResult(ArrayList<User> profileSearchResult) throws RemoteException;

    void updatePlaylists(Playlist newValue) throws RemoteException;

    void updateSongsFromPlaylist(Playlist newValue) throws RemoteException;
}
