package musicApp.server.model.search;

import musicApp.server.model.Song;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SongPredicate {
    public static Predicate<Song> hasSameSongTitle(String searchResult) {
        return p -> p.getTitle().equalsIgnoreCase(searchResult);
    }

    public static List<Song> filterSongs (List<Song> employees,
                                          Predicate<Song> predicate)
    {
        return employees.stream()
                .filter( predicate )
                .collect(Collectors.<Song>toList());
    }
}
