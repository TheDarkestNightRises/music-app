package musicApp.client.network.addAlbum;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMIAddAlbumClient implements AddAlbumClient {
    private RMIServer server;

    public RMIAddAlbumClient(RMIServer server) {
        this.server = server;
    }

    @Override
    public String uploadAlbumImage(String username, byte[] toByteArray) {
        try {
            return server.getAddAlbumServer().uploadAlbumImage(username, toByteArray);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Artist getArtist(User user) {
        try {
            return server.getAddAlbumServer().getArtist(user);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override public void createAlbum(String title, int year, String uploaded, Artist artist)
    {
        try {
           server.getAddAlbumServer().createAlbum(title,year,uploaded,artist);
        } catch (RemoteException e) {
            e.printStackTrace();

        }
    }
}
