package musicApp.client.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Album {
    private int id;
    private String title;
    private int publicationYear;
    private String picturePath;
    private String username;
    private ArrayList<Song> songs;
    private Artist artist;

    public Album(){};

    public Album(int id, String title, int publicationYear,
        String picturePath, String username,
        Artist artist)
    {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.picturePath = picturePath;
        this.username = username;
        this.songs = new ArrayList<>();
        this.artist = artist;
    }

    public Album(int id, String title, int publicationYear,
        String picturePath, String username,
        Artist artist, ArrayList<Song> songs)
    {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.picturePath = picturePath;
        this.username = username;
        this.artist = artist;
        this.songs = songs;
    }




    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public int getPublicationYear()
    {
        return publicationYear;
    }

    public String getPicturePath()
    {
        return picturePath;
    }

    public String getUsername()
    {
        return username;
    }

    public ArrayList<Song> getSongs()
    {
        return songs;
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setPublicationYear(int publicationYear)
    {
        this.publicationYear = publicationYear;
    }

    public void setPicturePath(String picturePath)
    {
        this.picturePath = picturePath;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setSongs(ArrayList<Song> songs)
    {
        this.songs = songs;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public Album copy()
    {
           return new Album(id,title,publicationYear,picturePath,username,artist,songs);
    }
}
