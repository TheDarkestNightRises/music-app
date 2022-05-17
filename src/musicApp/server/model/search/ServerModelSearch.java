package musicApp.server.model.search;

import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public interface ServerModelSearch {
    ArrayList<Song> fetchSortedList();

    void search(String newValue);
}
