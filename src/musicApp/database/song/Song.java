package musicApp.database.song;

public class Song
{
  private String song_id;
  private String title;
  private String file_path;
  private int length;
  private String picture_path;


  public Song(){}

  public Song(String song_id, String title, String file_path, int length,
      String picture_path)
  {
    this.song_id = song_id;
    this.title = title;
    this.file_path = file_path;
    this.length = length;
    this.picture_path = picture_path;
  }

  public String getSong_id()
  {
    return song_id;
  }

  public String getTitle()
  {
    return title;
  }

  public String getFile_path()
  {
    return file_path;
  }

  public int getLength()
  {
    return length;
  }

  public String getPicture_path()
  {
    return picture_path;
  }

  public void setSong_id(String song_id)
  {
    this.song_id = song_id;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setFile_path(String file_path)
  {
    this.file_path = file_path;
  }

  public void setLength(int length)
  {
    this.length = length;
  }

  public void setPicture_path(String picture_path)
  {
    this.picture_path = picture_path;
  }
}
