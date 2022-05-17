package musicApp;

import musicApp.database.follow.FollowDAOImpl;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;

public class Hope
{
  public static void main(String[] args) throws SQLException
  {
//    Album album = AlbumDAOImpl.getInstance().getAlbumById(1);
//    Artist artist = ArtistDAOImpl.getInstance().getArtistByName("lnprk");
//    System.out.println(SongDAOImpl.getInstance().getSongsFromAlbum(album));

//    System.out.println(album);
//    AlbumDAOImpl.getInstance().deleteAlbum(album);
//  Artist artist = ArtistDAOImpl.getInstance().getArtistByName("3daysgrace");
//    System.out.println(AlbumDAOImpl.getInstance().getArtistAlbums(artist));
      User emanuel = UsersDAOImpl.getInstance().getUserByName("emanuel");
    User andrei = UsersDAOImpl.getInstance().getUserByName("andrei");
//    PlaylistDAOImpl.getInstance().createPlayList("Nebunia lui Emanuel", "E nebunia mea", "I am my own picture",user);
//    System.out.println(UsersDAOImpl.getInstance().getPlaylistFromUserById(user,1));
//    User user1 = UsersDAOImpl.getInstance().getUserByName("hugo");
//    FollowDAOImpl.getInstance().Follow(user,user1);
//    System.out.println(FollowDAOImpl.getInstance().getFollowList(user));
//    AlbumDAOImpl.getInstance().insertAlbum("da",2022,"picture",artist);'
//     Playlist playlist = UsersDAOImpl.getInstance().getPlaylistFromUserById(user,1);
    FollowDAOImpl.getInstance().Follow(emanuel,andrei);
  }
}
