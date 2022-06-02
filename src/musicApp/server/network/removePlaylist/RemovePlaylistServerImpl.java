package musicApp.server.network.removePlaylist;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.removePlaylist.ServerModelRemovePlaylist;
import musicApp.shared.networking.RemovePlaylistServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemovePlaylistServerImpl implements RemovePlaylistServer {


    private final ServerModelRemovePlaylist serverModelRemovePlaylist;

    public RemovePlaylistServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelRemovePlaylist = serverModelFactory.getModelRemovePlaylist();
    }

    @Override
    public void removePlaylist(Playlist playlist) {
        serverModelRemovePlaylist.removePlaylist(playlist);
    }
}
