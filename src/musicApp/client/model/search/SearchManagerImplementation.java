package musicApp.client.model.search;

import javafx.collections.transformation.SortedList;
import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Song;

public class SearchManagerImplementation implements SearchManager{
    private final Client client;

    public SearchManagerImplementation(Client client) {
        this.client = client;
    }

    @Override
    public SortedList<Song> fetchSortedList() {
        return client.getSearchClient().fetchSortedList();
    }
}
