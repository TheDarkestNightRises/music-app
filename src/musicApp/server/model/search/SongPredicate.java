package musicApp.server.model.search;

import javafx.collections.transformation.FilteredList;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate responsible for filtering the song search results based on certain conditions:
 * if the search result is contained in any playlist title or artist name
 */
public class SongPredicate {
    public static Predicate<Song> containsSongTitleOrContainsArtist(String searchResult) {
        return p -> p.getTitle().contains(searchResult) || p.getArtist().getName().contains(searchResult);
    }

    /**
     * Method responsible for filtering the list based on the predicate above
     * @param songs array to be sorted
     * @param predicate condition
     * @return filtered list
     */
    public static ArrayList<Song> filterSongs(ArrayList<Song> songs, Predicate<Song> predicate) {
        return (ArrayList<Song>) songs.stream()
                .filter(predicate)
                .collect(Collectors.<Song>toList());
    }
}
