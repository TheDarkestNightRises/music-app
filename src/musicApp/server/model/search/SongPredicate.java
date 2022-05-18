package musicApp.server.model.search;

import javafx.collections.transformation.FilteredList;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SongPredicate {
    public static Predicate<Song> containsSongTitleOrContainsArtist(String searchResult) {
        return p -> p.getTitle().contains(searchResult) || p.getArtist().getName().contains(searchResult);
    }

    public static List<Song> filterSongs(ArrayList<Song> songs, Predicate<Song> predicate) {
        return songs.stream()
                .filter(predicate)
                .collect(Collectors.<Song>toList());
    }
}
