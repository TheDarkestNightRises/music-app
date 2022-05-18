package musicApp.server.model.search;

import musicApp.server.model.domainModel.Song;
import musicApp.util.Subject;

import java.util.ArrayList;

public interface ServerModelSearch extends Subject {
    ArrayList<Song> fetchSortedList();

    void search(String newValue);
}
