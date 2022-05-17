package musicApp.client.network.search;

import javafx.collections.transformation.SortedList;
import musicApp.server.model.Song;
import musicApp.shared.networking.RMIServer;

public interface SearchClient {
    void setServer(RMIServer server);

    SortedList<Song> fetchSortedList();
}
