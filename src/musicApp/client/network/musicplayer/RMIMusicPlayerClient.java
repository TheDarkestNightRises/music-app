package musicApp.client.network.musicplayer;

import musicApp.shared.networking.RMIServer;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIMusicPlayerClient implements MusicPlayerClient {
    private RMIServer server;

    @Override
    public ArrayList<File> getCurrentPlaylist() {
        try {
            return server.getMusicPlayerServer().getCurrentPlaylist();
        } catch (RemoteException e) {
            e.printStackTrace(); //Todo: Throw Runtime Exception catch in viewModel set error
            return null;
        }
    }

    public void setServer(RMIServer server) {
        this.server = server;
    }

    @Override
    public File fetchAlbumCover(String picturePath) {
        try {
            return server.getMusicPlayerServer().fetchAlbumCover(picturePath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
