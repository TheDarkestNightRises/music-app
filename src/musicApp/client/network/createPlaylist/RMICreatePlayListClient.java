package musicApp.client.network.createPlaylist;

import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMICreatePlayListClient implements CreatePlaylistClient {
    private RMIServer server;

    public RMICreatePlayListClient(RMIServer server) {
        this.server = server;
    }

    @Override
    public void createPlaylist(String title, String description,
                               User user) throws Exception {
        try {
            server.getCreatePlaylistServer().createPlaylist(title, description, user);
        } catch (RemoteException e) {
            throw new Exception("Could not connect to server");
        }
    }
}

