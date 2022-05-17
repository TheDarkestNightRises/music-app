package musicApp.server.model.search;

import javafx.collections.transformation.SortedList;
import musicApp.server.model.domainModel.Song;

public interface ServerModelSearch {
    SortedList<Song> fetchSortedList();
}
