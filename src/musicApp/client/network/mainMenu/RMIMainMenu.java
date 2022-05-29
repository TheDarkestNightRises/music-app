package musicApp.client.network.mainMenu;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIMainMenu implements MainMenuClient {
    private RMIServer server;

    public RMIMainMenu(RMIServer server) {
        this.server = server;
    }

    @Override
    public ArrayList<Song> fetchRandomSongs() {
        try {
            return server.getMainMenuServer().fetchRandomSongs();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Song> fetchLastSongs() {
        try {
            return server.getMainMenuServer().fetchLastSongs();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Album> fetchRandomAlbums() {
        try {
            return server.getMainMenuServer().fetchRandomAlbums();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
