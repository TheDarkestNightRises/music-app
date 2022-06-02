package musicApp.server.model.search;

import musicApp.server.model.domainModel.Album;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate responsible for filtering the albums search results based on certain conditions:
 * if the search result is contained in any of the album titles or artist names
 */
public class AlbumPredicate {
    public static Predicate<Album> containsAlbumTitleOrContainsArtist(String searchResult) {
        return p -> p.getTitle().contains(searchResult) || p.getArtist().getName().contains(searchResult);
    }

    /**
     * Method responsible for filtering the list based on the predicate above
     * @param albums array to be sorted
     * @param predicate condition
     * @return filtered list
     */
    public static ArrayList<Album> filterAlbums(ArrayList<Album> albums, Predicate<Album> predicate) {
        return (ArrayList<Album>) albums.stream()
                .filter(predicate)
                .collect(Collectors.<Album>toList());
    }
}
