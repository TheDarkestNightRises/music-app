package musicApp.server.network.search;

import javafx.collections.transformation.SortedList;
import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.search.SongPredicate;
import musicApp.shared.networking.SearchServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SearchServerImpl implements SearchServer {
    private ServerModel serverModel;

    public SearchServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModel = serverModel;
    }

    @Override
    public SortedList<Song> fetchSortedList() {
        return serverModel.getModelSearch().fetchSortedList();
    }
}
