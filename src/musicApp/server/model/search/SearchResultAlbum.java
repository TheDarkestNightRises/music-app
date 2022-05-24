package musicApp.server.model.search;

import musicApp.server.model.domainModel.Album;

import java.util.ArrayList;

public class SearchResultAlbum {
    private ArrayList<Album> albums;

    public SearchResultAlbum(ArrayList<Album> albums) {
        this.albums = albums;
    }
}
