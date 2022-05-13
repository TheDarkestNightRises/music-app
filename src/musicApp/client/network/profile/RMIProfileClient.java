package musicApp.client.network.profile;

import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIProfileClient implements ProfileClient{
    private RMIServer rmiServer;


    @Override
    public void setServer(RMIServer rmiServer) {
        this.rmiServer = rmiServer;
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
}
