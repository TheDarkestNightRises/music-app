package musicApp.client.network.addToPlaylist;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMIAddToPlaylistClient implements AddToPlaylistClient {
    private RMIServer server;

    public RMIAddToPlaylistClient(RMIServer server) {
        this.server = server;
    }


    @Override
    public void addToPlaylist(User user, Playlist playlist,
                              Song currentSong) throws Exception {
        try {
            server.getAddToPlaylistServer().addToPlaylist(user, playlist, currentSong);
        } catch (RemoteException ex) {
            throw new Exception("Could not connect to server");
        }
    }
}
