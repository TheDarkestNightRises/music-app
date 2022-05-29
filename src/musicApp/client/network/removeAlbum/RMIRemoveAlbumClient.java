package musicApp.client.network.removeAlbum;

import musicApp.server.model.domainModel.Album;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMIRemoveAlbumClient implements RemoveAlbumClient {
    private RMIServer server;

    public RMIRemoveAlbumClient(RMIServer server) {
        this.server = server;
    }


    @Override
    public void deleteAlbum(Album album) {
        try {
            server.getRemoveAlbumServer().removeAlbum(album);
        } catch (RemoteException e) {
            e.printStackTrace();

        }
    }
}
