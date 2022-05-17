package musicApp.server.network.search;

import javafx.collections.transformation.SortedList;
import musicApp.server.model.ServerModel;
import musicApp.server.model.Song;
import musicApp.shared.networking.SearchServer;

public class SearchServerImpl implements SearchServer {
    private ServerModel serverModel;
    private SortedList<Song> searchResultsSorted;

    public SearchServerImpl(ServerModel serverModel) {
        this.serverModel = serverModel;
    }

    @Override
    public SortedList<Song> fetchSortedList() {
        return searchResultsSorted;
    }
}
