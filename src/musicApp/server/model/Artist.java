package musicApp.server.model;

import java.util.ArrayList;

public class Artist {

    private String name;
    private ArrayList<Album> albums;

    public Artist(){};


    public Artist(String name) {

        this.name = name;
        this.albums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Album> getAlbums()
    {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums)
    {
        this.albums = albums;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString()
    {
        return "Artist{" + "name='" + name + '\'' + ", albums=" + albums + '}';
    }
}
