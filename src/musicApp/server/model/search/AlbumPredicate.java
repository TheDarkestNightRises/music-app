package musicApp.server.model.search;

import musicApp.server.model.domainModel.Album;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AlbumPredicate {
    public static Predicate<Album> containsAlbumTitleOrContainsArtist(String searchResult) {
        return p -> p.getTitle().contains(searchResult) || p.getArtist().getName().contains(searchResult);
    }

    public static ArrayList<Album> filterAlbums(ArrayList<Album> album, Predicate<Album> predicate) {
        return (ArrayList<Album>) album.stream()
                .filter(predicate)
                .collect(Collectors.<Album>toList());
    }
}
