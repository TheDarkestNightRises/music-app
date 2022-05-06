package musicApp.database.song;

public class Song
{
  private String cover;
  private String name;
  private String artist;
  private int length;
  private String picture_path;


  public Song(){}

  public Song(String cover, String name, String artist, int length,
      String picture_path)
  {
    this.cover = cover;
    this.name = name;
    this.artist = artist;
    this.length = length;
    this.picture_path = picture_path;
  }



  public void setLength(int length)
  {
    this.length = length;
  }

  public void setPicture_path(String picture_path)
  {
    this.picture_path = picture_path;
  }

  public int getLength()
  {
    return length;
  }

  public String getPicture_path()
  {
    return picture_path;
  }

  public String getCover()
  {
    return cover;
  }

  public void setCover(String cover)
  {
    this.cover = cover;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getArtist()
  {
    return artist;
  }

  public void setArtist(String artist)
  {
    this.artist = artist;
  }
}
