package musicApp.server.network.removeAlbum;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.removeAlbum.ServerModelRemoveAlbum;
import musicApp.shared.networking.RemoveAlbumServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoveAlbumServerImpl implements RemoveAlbumServer {


    private final ServerModelRemoveAlbum serverModelRemoveAlbum;

    public RemoveAlbumServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelRemoveAlbum = serverModelFactory.getModelRemoveAlbum();
    }

    @Override
    public void removeAlbum(Album album) throws RemoteException {
        serverModelRemoveAlbum.removeAlbum(album);
    }
}
