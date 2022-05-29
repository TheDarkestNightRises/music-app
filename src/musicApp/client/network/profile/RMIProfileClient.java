package musicApp.client.network.profile;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIProfileClient implements ProfileClient {
    private RMIServer rmiServer;

    public RMIProfileClient(RMIServer server) {
        this.rmiServer = server;
    }


    @Override
    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        try {
            return rmiServer.getProfileServer().fetchPlaylistsForUser(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
        try {
            return rmiServer.getProfileServer().fetchSongsForPlaylist(playlist);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] fetchProfilePicture(String profile_picture) {
        try {
            return rmiServer.getProfileServer().fetchProfilePicture(profile_picture);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Album> fetchArtistAlbums(User user) {
        try {
            return rmiServer.getProfileServer().fetchArtistAlbums(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isArtist(User user) {
        try {
            return rmiServer.getProfileServer().isArtist(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void follow(User user0, User user) {
        try {
            rmiServer.getProfileServer().follow(user0, user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void unfollow(User user0, User user) {
        try {
            rmiServer.getProfileServer().unfollow(user0, user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
