package musicApp.client.model.addAlbum;

import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

/**
 * The interface for the AddAlbumManager,model in the client.It's used to add albums
 */
public interface AddAlbumManager {
    String uploadAlbumImage(String username, byte[] toByteArray);

    Artist getArtist(User user);

    void createAlbum(String title, int year, String uploaded, Artist artist);
}
