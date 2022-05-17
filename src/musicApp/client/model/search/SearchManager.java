package musicApp.client.model.search;

import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public interface SearchManager {
    ArrayList<Song> fetchSortedList();

    void search(String newValue);
}
