package musicApp;

import musicApp.database.album.Album;
import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.artist.Artist;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.database.follow.FollowDAOImpl;
import musicApp.database.users.User;
import musicApp.database.users.UsersDAOImpl;

import java.sql.SQLException;

public class Hope
{
  public static void main(String[] args) throws SQLException
  {
//    Album album = AlbumDAOImpl.getInstance().getAlbumById(0);
//    System.out.println(album);
//    AlbumDAOImpl.getInstance().deleteAlbum(album);
//    Artist artist = ArtistDAOImpl.getInstance().getArtistByName("3daysgrace");
//    System.out.println(AlbumDAOImpl.getInstance().getArtistAlbums(artist));
    User user = UsersDAOImpl.getInstance().getUserByName("emanuel");
    User user1 = UsersDAOImpl.getInstance().getUserByName("hugo");
    FollowDAOImpl.getInstance().Follow(user,user1);
  }
}
