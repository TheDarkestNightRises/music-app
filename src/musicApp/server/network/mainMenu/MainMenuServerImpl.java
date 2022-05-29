package musicApp.server.network.mainMenu;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.mainMenu.ServerModelMainMenu;
import musicApp.shared.networking.MainMenuServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MainMenuServerImpl implements MainMenuServer {


    private final ServerModelMainMenu serverModelMainMenu;

    public MainMenuServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelMainMenu = serverModelFactory.getModelMainMenu();
    }

    @Override
    public ArrayList<Song> fetchRandomSongs() {
        return serverModelMainMenu.fetchRandomSongs();
    }

    @Override
    public ArrayList<Song> fetchLastSongs() throws RemoteException {
        return serverModelMainMenu.fetchLastSongs();
    }

    @Override
    public ArrayList<Album> fetchRandomAlbums() throws RemoteException {
        return serverModelMainMenu.fetchRandomAlbums();
    }
}
