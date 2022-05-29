package musicApp.server.network.createPlaylist;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.createPlaylist.ServerModelCreatePlaylist;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.CreatePLayListServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CreatePlaylistServerImpl implements CreatePLayListServer {


    private final ServerModelCreatePlaylist serverModelCreatePlaylist;

    public CreatePlaylistServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelCreatePlaylist = serverModelFactory.getServerModelCreatePlaylist();
    }

    @Override
    public void createPlaylist(String title, String description, User user) throws Exception {
        serverModelCreatePlaylist.createPlaylist(title, description, user);
    }
}
