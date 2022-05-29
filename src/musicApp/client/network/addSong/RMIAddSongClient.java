package musicApp.client.network.addSong;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIAddSongClient implements AddSongClient {
    RMIServer server;

    public RMIAddSongClient(RMIServer server) {
        this.server = server;
    }


    @Override
    public ArrayList<Album> getAlbumsOfUser(User user) throws Exception {
        try {
            return server.getAddSongServer().getAlbumsOfUser(user);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new Exception("Could not connect to server");
        }
    }

    @Override
    public void addSong(String title, byte[] songBytes, Album album,
                        User user) throws Exception {
        try {
            server.getAddSongServer().addSong(title, songBytes, album, user);
        } catch (RemoteException exception) {
            exception.printStackTrace();
            throw new Exception("Could not connect to server");
        }
    }
}
