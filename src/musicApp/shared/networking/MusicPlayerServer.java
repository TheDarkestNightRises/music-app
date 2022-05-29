package musicApp.shared.networking;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MusicPlayerServer extends Remote {
    //-----------MusicPlayer-------------
    ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) throws RemoteException;

    byte[] fetchAlbumCover(String picturePath) throws RemoteException;

    void addToLikedSongs(User user, Song song) throws RemoteException;

    void removeToLikedSongs(User user, Song song) throws RemoteException;

}
