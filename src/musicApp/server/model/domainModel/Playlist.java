package musicApp.server.model.domainModel;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable
{
  private int playlist_id;
  private String title;
  private String description;
  private String picture_name;
  private ArrayList<Song> songs;

  @Override public String toString()
  {
    return "Playlist{" + "playlist_id=" + playlist_id + ", title='" + title + '\'' + ", description='" + description + '\''
        + ", picture_name='" + picture_name + '\'' + ", songs=" + songs + '}';
  }

  public Playlist(int playlist_id, String title, String description, String picture_name)
  {
    this.playlist_id = playlist_id;
    this.title = title;
    this.description = description;
    this.picture_name = picture_name;
    this.songs = new ArrayList<>();
  }

  public Playlist(ArrayList<Song> songs)
  {
    this.songs = songs;
  }

  public Playlist(int playlist_id, String title, String description, String picture_name, ArrayList<Song> songs)
  {
    this.playlist_id = playlist_id;
    this.title = title;
    this.description = description;
    this.picture_name = picture_name;
    this.songs = songs;
  }

  public int getPlaylist_id()
  {
    return playlist_id;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getPicture_name()
  {
    return picture_name;
  }

  public void setPicture_name(String picture_name)
  {
    this.picture_name = picture_name;
  }

  public Playlist copy()
  {
    return new Playlist(playlist_id, title, description, picture_name, songs);
  }

  public ArrayList<Song> getSongs()
  {
    return songs;
  }

  public Song getSong(int number)
  {
    return songs.get(number);
  }
}
