package musicApp.database.profile;

public class Playlist
{
  private int playlist_id;
  private String title;
  private String description;
  private String picture_name;

  @Override public String toString()
  {
    return "Playlist{" + "playlist_id=" + playlist_id + ", title='" + title
        + '\'' + ", description='" + description + '\'' + ", picture_name='"
        + picture_name + '\'' + '}';
  }

  public Playlist(int playlist_id, String title, String description,
      String picture_name)
  {
    this.playlist_id = playlist_id;
    this.title = title;
    this.description = description;
    this.picture_name = picture_name;
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
}