package musicApp.shared.networking;

import java.io.File;
import java.io.FileInputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MusicPlayerServer extends Remote {
    //-----------MusicPlayer-------------
    ArrayList<File> getCurrentPlaylist() throws RemoteException;

    FileInputStream fetchAlbumCover(String picturePath) throws RemoteException;
}
