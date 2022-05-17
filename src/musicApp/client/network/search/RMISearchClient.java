package musicApp.client.network.search;

import javafx.collections.transformation.SortedList;
import musicApp.server.model.Song;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMISearchClient implements SearchClient{
    private RMIServer server;

    @Override
    public void setServer(RMIServer server) {
        this.server = server;
    }

    @Override
    public SortedList<Song> fetchSortedList() {
        try {
            return server.getSearchServer().fetchSortedList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
