package musicApp.server.model.domainModel;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable
{
  private int id;
  private String title;
  private int publicationYear;
  private String picturePath;
  private ArrayList<Song> songs;
  private Artist artist;

  public Album()
  {
  }

  ;

  public Album(int id, String title, int publicationYear, String picturePath, Artist artist)
  {
    this.id = id;
    this.title = title;
    this.publicationYear = publicationYear;
    this.picturePath = picturePath;
    this.songs = new ArrayList<>();
    this.artist = artist;
  }

  public Album(int id, String title, int publicationYear, String picturePath, Artist artist, ArrayList<Song> songs)
  {
    this.id = id;
    this.title = title;
    this.publicationYear = publicationYear;
    this.picturePath = picturePath;
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
    return new Album(id, title, publicationYear, picturePath, artist, songs);
  }

  @Override public String toString()
  {
    return "Album{" + "id=" + id + ", title='" + title + '\'' + ", publicationYear=" + publicationYear + ", picturePath='"
        + picturePath + '\'' + ", songs=" + songs + ", artist=" + artist.getName() + '}';
  }
}
