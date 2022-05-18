package musicApp.client.model.search;

import musicApp.server.model.domainModel.Song;
import musicApp.util.Subject;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public interface SearchManager extends Subject {
    ArrayList<Song> fetchSortedList();

    void search(String newValue);

    void onNewSearch(PropertyChangeEvent event);
}
