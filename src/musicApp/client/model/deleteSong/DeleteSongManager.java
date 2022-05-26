package musicApp.client.model.deleteSong;

import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public interface DeleteSongManager
{
  ArrayList<String> getArtistSongsTitles(User user) throws Exception;
  ArrayList<Song> getSongsOfUser(User user) throws Exception;
  void deleteSong(int selectedIndex) throws Exception;
}
