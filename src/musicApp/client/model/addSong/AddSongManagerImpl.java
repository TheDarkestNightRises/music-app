package musicApp.client.model.addSong;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the AddSongManagerImpl. This class is a proxy to make sure that the client model
 * implements the same interface as the server model. This class should be responsible to add albums
 */
public class AddSongManagerImpl implements AddSongManager
{
  private Client client;
  private ArrayList<Album> tempAlbums;

  public AddSongManagerImpl(Client client)
  {
    this.client = client;
  }
  @Override public ArrayList<String> getAlbumTitles(User user) throws Exception
  {
    tempAlbums = getAlbumsOfUser(user);
    ArrayList<String> titles = new ArrayList<>();
    for (Album album : tempAlbums)
    {
      titles.add(album.getTitle());
    }
    return titles;
  }

  @Override public ArrayList<Album> getAlbumsOfUser(User user) throws Exception
  {
    return client.getAddSongClient().getAlbumsOfUser(user);
  }

  @Override public void addSong(String title, File songFile, int index,
      User user) throws Exception
  {
    byte [] songBytes;
    songBytes=new byte[(int) songFile.length()];
    FileInputStream in;
    try {
      in = new FileInputStream(songFile);
      in.read(songBytes, 0, songBytes.length);
      in.close();
      client.getAddSongClient().addSong(title, songBytes, tempAlbums.get(index), user);

    } catch (IOException e) {

      e.printStackTrace();
      throw new Exception("file cannot be processed");
    }

  }

}
