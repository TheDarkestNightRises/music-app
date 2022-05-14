package musicApp.server.network.musicplayer;

import musicApp.server.model.ServerModel;
import musicApp.shared.networking.MusicPlayerServer;

import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MusicPlayerServerImpl implements MusicPlayerServer {
    private final ServerModel serverModel;

    public MusicPlayerServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.serverModel = serverModel;
    }

    @Override
    public ArrayList<File> getCurrentPlaylist() {
        return serverModel.getModelMusic().getCurrentPlaylist();
    }

    @Override
    public byte[] fetchAlbumCover(String picturePath) {
        return serverModel.getModelMusic().fetchAlbumCover(picturePath);
    }
}
