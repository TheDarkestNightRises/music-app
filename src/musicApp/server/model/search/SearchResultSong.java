package musicApp.server.model.search;

import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class SearchResultSong {
    private ArrayList<Song> songs;

    public SearchResultSong(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
