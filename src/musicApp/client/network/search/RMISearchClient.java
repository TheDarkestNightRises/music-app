package musicApp.client.network.search;

import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMISearchClient implements SearchClient{
    private RMIServer server;

    @Override
    public void setServer(RMIServer server) {
        this.server = server;
    }

    @Override
    public ArrayList<Song> fetchSortedList() {
        try {
            return server.getSearchServer().fetchSortedList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void searchSong(String search) {
        try {
            server.getSearchServer().searchSong(search);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchAlbum(String search) {
        try {
            server.getSearchServer().searchAlbum(search);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchProfile(String search) {
        try {
            server.getSearchServer().searchProfile(search);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
