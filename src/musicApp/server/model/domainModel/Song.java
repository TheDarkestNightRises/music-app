package musicApp.server.model.domainModel;

import java.io.Serializable;

public class Song implements Serializable
{
  private int song_id;
  private String title;
  private String file_path;
  private String length;
  private Album album;
  private Artist artist;

  public Song()
  {
  }

  public Song(int song_id, String title, String file_path, String length, Album album, Artist artist)

  {
    this.song_id = song_id;
    this.title = title;
    this.file_path = file_path;
    this.length = length;
    this.album = album;
    this.artist = artist;
  }

  public int getSong_id()
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

  public String getLength()
  {
    return length;
  }

  public void setSong_id(int song_id)
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

  public void setLength(String length)
  {
    this.length = length;
  }

  public Album getAlbum()
  {
    return album;
  }

  public Artist getArtist()
  {
    return artist;
  }

  public void setAlbum(Album album)
  {
    this.album = album;
  }

  public void setArtist(Artist artist)
  {
    this.artist = artist;
  }

  @Override public String toString()
  {
    return "Song{" + "song_id=" + song_id + ", title='" + title + '\'' + ", file_path='" + file_path + '\'' + ", length='"
        + length + '\'' + ", album=" + album.getTitle() + ", artist=" + artist.getName() + '}';
  }
}
