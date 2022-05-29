package musicApp.server.network.addSong;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.addSong.ServerModelAddSong;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.shared.networking.AddSongServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AddSongServerImpl implements AddSongServer {

    private final ServerModelAddSong serverModelAddSong;

    public AddSongServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelAddSong = serverModelFactory.getModelAddSong();
    }

    @Override
    public ArrayList<Album> getAlbumsOfUser(User user) throws Exception {
        return serverModelAddSong.getAlbumsOfUser(user);
    }

    @Override
    public void addSong(String title, byte[] songBytes, Album album, User user) throws Exception {
        serverModelAddSong.addSong(title, songBytes, album, user);
    }
}
