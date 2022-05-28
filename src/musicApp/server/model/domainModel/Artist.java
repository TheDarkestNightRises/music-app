package musicApp.server.model.domainModel;

import musicApp.database.users.UsersDAOImpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Artist extends User implements Serializable
{

  private String name;
  private ArrayList<Album> albums;

  public Artist()
  {
    super("", "", "", "", "", "", null);
  }

  ;

  public Artist(String name)
  {
    super("", "", "", "", "", "", null);
    this.name = name;
    this.albums = new ArrayList<>();

  }

  public String getName()
  {
    return name;
  }

  public ArrayList<Album> getAlbums()
  {
    return albums;
  }

  public void setAlbums(ArrayList<Album> albums)
  {
    this.albums = albums;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override public String toString()
  {
    return "Artist{" + "name='" + name + '\'' + ", albums=" + albums + '}';
  }
}
