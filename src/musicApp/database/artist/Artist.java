package musicApp.database.artist;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist {

    private SimpleStringProperty name;

    public Artist() {

        this.name = new SimpleStringProperty();
    }
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return "Artist{" +
                ", name='" + name + '\'' +
                '}';
    }
}
