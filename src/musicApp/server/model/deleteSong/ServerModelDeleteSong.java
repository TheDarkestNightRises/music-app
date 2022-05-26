package musicApp.server.model.deleteSong;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public interface ServerModelDeleteSong
{
  ArrayList<Song> getSongsOfUser(User user) throws Exception;
  Artist getArtistOfUser(User user);
  void deleteSong(Song song) throws Exception;
}
