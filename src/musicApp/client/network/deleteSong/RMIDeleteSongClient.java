package musicApp.client.network.deleteSong;

import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIDeleteSongClient implements DeleteSongClient {

    private RMIServer server;

    public RMIDeleteSongClient(RMIServer server) {
        this.server = server;
    }


    @Override
    public ArrayList<Song> getSongsOfUser(User user) throws Exception {
        try {
            return server.getDeleteSongServer().getSongsOfUser(user);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            throw new Exception("Could not connect to server");
        }

    }

    @Override
    public void deleteSong(Song song) throws Exception {
        try {
            server.getDeleteSongServer().deleteSong(song);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new Exception();
        }

    }
}
