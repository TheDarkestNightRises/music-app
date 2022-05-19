package musicApp.server.network.mainMenu;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.MainMenuServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MainMenuServerImpl implements MainMenuServer {
    private final ServerModel serverModel;

    public MainMenuServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.serverModel = serverModel;
    }

    @Override
    public ArrayList<Song> fetchRandomSongs() {
        return serverModel.getModelMainMenu().fetchRandomSongs();
    }
}
