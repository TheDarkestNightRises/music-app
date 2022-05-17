package musicApp.client.model.search;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class SearchManagerImplementation implements SearchManager{
    private final Client client;

    public SearchManagerImplementation(Client client) {
        this.client = client;
    }

    @Override
    public ArrayList<Song> fetchSortedList() {
        return client.getSearchClient().fetchSortedList();
    }

    @Override
    public void search(String newValue) {
        client.getSearchClient().search(newValue);
    }
}
