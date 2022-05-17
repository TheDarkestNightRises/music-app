package musicApp.client.model.search;

import javafx.collections.transformation.SortedList;
import musicApp.server.model.domainModel.Song;

public interface SearchManager {
    SortedList<Song> fetchSortedList();
}
