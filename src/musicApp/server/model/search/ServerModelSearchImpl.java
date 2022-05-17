package musicApp.server.model.search;

import javafx.collections.transformation.SortedList;
import musicApp.server.model.domainModel.Song;

public class ServerModelSearchImpl implements ServerModelSearch{
    private SongPredicate songPredicate;
    private SortedList<Song> searchResultsSorted;

    @Override
    public SortedList<Song> fetchSortedList() {
        return searchResultsSorted;
    }
}
