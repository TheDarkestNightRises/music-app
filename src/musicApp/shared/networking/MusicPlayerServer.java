package musicApp.shared.networking;

import javafx.scene.image.Image;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MusicPlayerServer extends Remote {
    //-----------MusicPlayer-------------
    ArrayList<File> getCurrentPlaylist() throws RemoteException;

    Image fetchAlbumCover(String picturePath) throws RemoteException;
}
