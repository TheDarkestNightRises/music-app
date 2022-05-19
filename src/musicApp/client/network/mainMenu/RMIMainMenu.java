package musicApp.client.network.mainMenu;

import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIMainMenu implements MainMenuClient{
    private RMIServer server;

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
    public void setServer(RMIServer server) {
        this.server = server;
    }
}
