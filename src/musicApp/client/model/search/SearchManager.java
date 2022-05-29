package musicApp.client.model.search;

import musicApp.server.model.domainModel.Song;
import musicApp.util.Subject;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public interface SearchManager extends Subject {


    void searchSong(String newValue);

    void onNewSearch(PropertyChangeEvent event);

    void searchAlbum(String search);

    void searchProfile(String search);
}
