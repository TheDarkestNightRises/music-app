package musicApp.server.network.deleteSong;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.deleteSong.ServerModelDeleteSong;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.DeleteSongServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DeleteSongServerImpl implements DeleteSongServer {

    private final ServerModelDeleteSong serverModelDeleteSong;

    public DeleteSongServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelDeleteSong = serverModelFactory.getModelDeleteSong();
    }

    @Override
    public ArrayList<Song> getSongsOfUser(User user) throws Exception {
        return serverModelDeleteSong.getSongsOfUser(user);
    }

    @Override
    public void deleteSong(Song song) throws Exception {
        serverModelDeleteSong.deleteSong(song);
    }
}
