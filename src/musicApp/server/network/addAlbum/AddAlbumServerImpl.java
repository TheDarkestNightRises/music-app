package musicApp.server.network.addAlbum;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.addAlbum.ServerModelAddAlbum;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.AddAlbumServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddAlbumServerImpl implements AddAlbumServer {


    private final ServerModelAddAlbum serverModelAddAlbum;

    public AddAlbumServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelAddAlbum = serverModelFactory.getModelAddAlbums();
    }

    @Override
    public String uploadAlbumImage(String username, byte[] toByteArray) {
        String path = serverModelAddAlbum.uploadAlbumPicture(username, toByteArray);
        return path;
    }

    @Override
    public Artist getArtist(User user) {
        return serverModelAddAlbum.getArtist(user);
    }

    @Override public void createAlbum(String title, int year, String uploaded, Artist artist) throws RemoteException
    {
        serverModelAddAlbum.createAlbum(title,year,uploaded,artist);
    }
}
