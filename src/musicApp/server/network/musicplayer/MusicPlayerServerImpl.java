package musicApp.server.network.musicplayer;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.MusicPlayerServer;

import java.io.File;
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
    public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) {
        return serverModel.getModelMusic().getCurrentPlaylistFiles(playlist);
    }

    @Override
    public byte[] fetchAlbumCover(String picturePath) {
        return serverModel.getModelMusic().fetchAlbumCover(picturePath);
    }

    @Override public void addToLikedSongs(User user, Song song) throws RemoteException
    {
        serverModel.getModelMusic().addToLikedSongs(user, song);
    }

    @Override public void removeToLikedSongs(User user) throws RemoteException
    {
        serverModel.getModelMusic().removeToLikedSongs(user);
    }
}
