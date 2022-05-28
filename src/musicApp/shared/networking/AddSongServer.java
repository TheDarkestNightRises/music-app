package musicApp.shared.networking;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;

import java.rmi.Remote;
import java.util.ArrayList;

public interface AddSongServer extends Remote
{
  ArrayList<Album> getAlbumsOfUser(User user) throws Exception;
  void addSong(String title, byte[] songBytes, Album album, User user) throws Exception;
}
