package musicApp.client.network.search;

import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.RMIServer;

import java.util.ArrayList;

public interface SearchClient {
    void setServer(RMIServer server);

    ArrayList<Song> fetchSortedList();

    void search(String newValue);
}
