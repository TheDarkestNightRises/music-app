package musicApp.client.network.removePlaylist;

import musicApp.server.model.domainModel.Playlist;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMIRemovePlaylistClient implements RemovePlaylistClient {
    private RMIServer server;

    public RMIRemovePlaylistClient(RMIServer server) {
        this.server = server;
    }

    @Override
    public void removePlaylist(Playlist playlist) {
        try {
            server.getRemovePlaylistServer().removePlaylist(playlist);
        } catch (RemoteException e) {
            e.printStackTrace();

        }
    }

}
