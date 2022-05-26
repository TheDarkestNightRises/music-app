package musicApp.client.model.deleteSong;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public class DeleteSongManagerImplementation implements DeleteSongManager
{
  Client client;
  ArrayList<Song> tempSongs;
  public DeleteSongManagerImplementation(Client client)
  {
    this.client = client;
    this.tempSongs = new ArrayList<>();
  }

  @Override public ArrayList<String> getArtistSongsTitles(User user) throws Exception
  {
    tempSongs = getSongsOfUser(user);
    ArrayList<String> titles = new ArrayList<>();
    for (Song song : tempSongs)
    {
      titles.add(song.getTitle());
    }
    return titles;
  }

  @Override public ArrayList<Song> getSongsOfUser(User user) throws Exception
  {
    return client.getDeleteSongClient().getSongsOfUser(user);
  }

  @Override public void deleteSong(int selectedIndex) throws Exception
  {
    client.getDeleteSongClient().deleteSong(tempSongs.get(selectedIndex));
  }
}
