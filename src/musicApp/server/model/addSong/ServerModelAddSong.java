package musicApp.server.model.addSong;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public interface ServerModelAddSong
{
  ArrayList<Album> getAlbumsOfUser(User user) throws Exception;
  Artist getArtistOfUser(User user);
  void addSong(String title, byte[] songBytes, Album album, User user) throws Exception;
}
