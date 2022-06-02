package musicApp.client.model.addAlbum;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

/**
 * This is the AddAlbumManagerImplementation. This class is a proxy to make sure that the client model
 * implements the same interface as the server model. This class should be responsible to add albums
 */
public class AddAlbumManagerImplementation implements AddAlbumManager
{
  private Client client;

  /**
   * This is the constructor for AddAlbumManagerImplementation.
   * @param client facade to get their respective client
   */
  public AddAlbumManagerImplementation(Client client)
  {
    this.client = client;
  }

  /**
   * Delegates to client
   * @param username for identification
   * @param toByteArray image byte array
   * @return string
   */
  @Override public String uploadAlbumImage(String username, byte[] toByteArray)
  {
    return client.getAddAlbumClient().uploadAlbumImage(username, toByteArray);
  }

  /**
   * Delegates to client.
   * @param user to verify if artist
   * @return artist
   */
  @Override public Artist getArtist(User user)
  {
    return client.getAddAlbumClient().getArtist(user);
  }

  /**
   * Delegates to client
   * @param title
   * @param year
   * @param uploaded
   * @param artist
   */
  @Override public void createAlbum(String title, int year, String uploaded, Artist artist)
  {
     client.getAddAlbumClient().createAlbum(title,year,uploaded,artist);
  }
}
