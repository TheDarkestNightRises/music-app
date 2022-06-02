package musicApp.client.network.musicplayer;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIMusicPlayerClient implements MusicPlayerClient {
    private RMIServer server;

    public RMIMusicPlayerClient(RMIServer server) {
        this.server = server;
    }

    @Override
    public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) {
        try {
            return server.getMusicPlayerServer().getCurrentPlaylistFiles(playlist);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public byte[] fetchAlbumCover(String picturePath) {
        try {
            return server.getMusicPlayerServer().fetchAlbumCover(picturePath);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addToLikedSongs(User user, Song song) {
        try {
            server.getMusicPlayerServer().addToLikedSongs(user, song);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeToLikedSongs(User user, Song song) {
        try {
            server.getMusicPlayerServer().removeToLikedSongs(user, song);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
