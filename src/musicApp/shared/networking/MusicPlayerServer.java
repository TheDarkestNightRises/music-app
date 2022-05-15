package musicApp.shared.networking;

import musicApp.server.model.Playlist;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MusicPlayerServer extends Remote {
    //-----------MusicPlayer-------------
    ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) throws RemoteException;

    byte[] fetchAlbumCover(String picturePath) throws RemoteException;
}
