package musicApp.server.network.profile;

import musicApp.server.model.domainModel.Album;
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

    @Override
    public byte[] fetchProfilePicture(String profile_picture) throws RemoteException {
        return serverModel.getModelProfile().fetchProfilePicture(profile_picture);
    }

    @Override public ArrayList<Album> fetchArtistAlbums(User user) throws RemoteException
    {
        return serverModel.getModelProfile().fetchArtistAlbums(user);
    }

    @Override public boolean isArtist(User user) throws RemoteException
    {
        return serverModel.getModelProfile().isArtist(user);
    }

    @Override public void follow(User user0, User user) throws RemoteException
    {
        serverModel.getModelProfile().follow(user0,user);
    }

    @Override public void unfollow(User user0, User user) throws RemoteException
    {
        serverModel.getModelProfile().unfollow(user0,user);
    }
}
