package musicApp.server.network.profile;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.ProfileServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ProfileServerImpl implements ProfileServer {
    private final ServerModel serverModel;

    public ProfileServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.serverModel = serverModel;
    }


    @Override
    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        return serverModel.getModelProfile().fetchPlaylistsForUser(user);
    }

    @Override
    public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
        return serverModel.getModelProfile().fetchSongsForPlaylist(playlist);
    }
}
