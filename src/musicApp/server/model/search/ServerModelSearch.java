package musicApp.server.model.search;

import musicApp.server.model.domainModel.Song;
import musicApp.util.Subject;

import java.util.ArrayList;

/**
 * This class that implements this is responsible for searching song, albums,profiles.
 */
public interface ServerModelSearch extends Subject {

    void searchSong(String newValue);

    void searchAlbum(String search);

    void searchProfile(String search);
}
