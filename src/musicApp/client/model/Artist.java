package musicApp.client.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                ", name='" + name + '\'' +
                '}';
    }
}
