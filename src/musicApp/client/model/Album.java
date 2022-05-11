package musicApp.client.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Album {
    private SimpleIntegerProperty id;
    private SimpleStringProperty title;
    private SimpleIntegerProperty publicationYear;
    private SimpleStringProperty picturePath;
    private SimpleStringProperty username;

    public Album() {
        this.id = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.publicationYear = new SimpleIntegerProperty();
        this.picturePath = new SimpleStringProperty();
        this. username = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getArtistId() {
        return publicationYear.get();
    }


    public String getPicturePath()
    {
        return picturePath.get();
    }

    public void setPublicationYear(int publicationYear)
    {
        this.publicationYear.set(publicationYear);
    }

    public int getPublicationYear()
    {
        return publicationYear.get();
    }

    public SimpleIntegerProperty publicationYearProperty()
    {
        return publicationYear;
    }

    public void setUsername(String username)
    {
        this.username.set(username);
    }

    public String getUsername()
    {
        return username.get();
    }

    public void setArtistId(int artistId) {
        this.id.set(artistId);
    }

    public void setPicturePath(String picturePath)
    {
        this.picturePath.set(picturePath);
    }

    @Override public String toString()
    {
        return "Album{" + "id=" + id + ", title=" + title + ", publicationYear="
            + publicationYear + ", picturePath=" + picturePath + ", username="
            + username + '}';
    }
}
