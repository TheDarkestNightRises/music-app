package musicApp.server.network.search;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.search.ServerModelSearch;
import musicApp.shared.networking.SearchServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SearchServerImpl implements SearchServer {
    private final ServerModelSearch serverModelSearch;

    public SearchServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelSearch = serverModelFactory.getModelSearch();
    }

    @Override
    public void searchSong(String search) {
        serverModelSearch.searchSong(search);
    }

    @Override
    public void searchAlbum(String search) {
        serverModelSearch.searchAlbum(search);
    }

    @Override
    public void searchProfile(String search) {
        serverModelSearch.searchProfile(search);
    }
}
