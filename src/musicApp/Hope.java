package musicApp;

import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.database.song.SongDAOImpl;
import musicApp.server.model.Album;
import musicApp.server.model.Artist;
import musicApp.server.model.Song;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Hope
{
  public static void main(String[] args) throws SQLException
  {
    Album album = AlbumDAOImpl.getInstance().getAlbumById(1);
    Artist artist = ArtistDAOImpl.getInstance().getArtistByName("lnprk");
    System.out.println(SongDAOImpl.getInstance().getSongsFromAlbum(album));

//    System.out.println(album);
//    AlbumDAOImpl.getInstance().deleteAlbum(album);
//  Artist artist = ArtistDAOImpl.getInstance().getArtistByName("3daysgrace");
//    System.out.println(AlbumDAOImpl.getInstance().getArtistAlbums(artist));
//    User user = UsersDAOImpl.getInstance().getUserByName("lnprk");
//    User user1 = UsersDAOImpl.getInstance().getUserByName("hugo");
//    FollowDAOImpl.getInstance().Follow(user,user1);
//    System.out.println(FollowDAOImpl.getInstance().getFollowList(user));
//    AlbumDAOImpl.getInstance().insertAlbum("da",2022,"picture",artist);
  }
}
