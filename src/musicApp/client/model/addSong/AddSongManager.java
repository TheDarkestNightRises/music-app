package musicApp.client.model.addSong;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The interface for the AddAlbumManager,model in the client.It's used to add songs
 */
public interface AddSongManager
{
  ArrayList<String> getAlbumTitles(User user) throws Exception;
  ArrayList<Album> getAlbumsOfUser(User user) throws Exception;
  void addSong(String title, File songFile, int index, User user)
      throws Exception;
}
