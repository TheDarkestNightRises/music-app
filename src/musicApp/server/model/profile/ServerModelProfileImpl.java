package musicApp.server.model.profile;

import musicApp.database.artist.ArtistDAOImpl;
import musicApp.database.follow.FollowDAOImpl;
import musicApp.server.model.domainModel.*;
import musicApp.server.serverData.filemanager.FileManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Server Model Profile is responsible for fetching playlists for the users and following and unfollowing
 */
public class ServerModelProfileImpl implements ServerModelProfile {
    private FileManager fileManager;

    /**
     * The server needs the FileManager to get the profile
     */
    public ServerModelProfileImpl() {
        this.fileManager = FileManager.getInstance();
    }

    /**
     * This will delegate to the DAO to get all the playlists from the database
     * @param user need to know for which user
     * @return All the playlists that the users created with no songs inside
     */
    @Override
    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        GetAllPlaylistsTask getAllPlaylistsTask = new GetAllPlaylistsTask(user);
        new Thread(getAllPlaylistsTask).start();
        try {
            return getAllPlaylistsTask.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * This will delegate to the DAO to get all the songs for a playlist from the database
     * @param playlist need to know for which playlist
     * @return All the songs for that particular playlist
     */
    @Override
    public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
        GetAllSongsFromPlaylistTask getAllSongsFromPlaylistTask = new GetAllSongsFromPlaylistTask(playlist);
        new Thread(getAllSongsFromPlaylistTask).start();
        try {
            return getAllSongsFromPlaylistTask.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Fetch picture for profile ,delegates to file manager
     * @param profile_picture path to the profile picture
     * @return byte array
     */
    @Override
    public byte[] fetchProfilePicture(String profile_picture) {
        System.out.println(profile_picture);
        return fileManager.fetchPhotoFromProfile(profile_picture);
    }



    /**
     * This will delegate to the DAO to get all the albums for a artist from the database
     * @param user need to know for which artist
     * @return All the albums
     */
    @Override public ArrayList<Album> fetchArtistAlbums(User user)
    {
        try
        {
            System.out.println("user423234224242333242 : " + user.getUsername());
            Artist artist = ArtistDAOImpl.getInstance().getArtistByName(user.getUsername());
            System.out.println("artist : " + artist.getUsername());
            return ArtistDAOImpl.getInstance().getArtistAlbums(artist);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method checks if an user is an artist
     * @param user which user
     * @return true if is artist , false if isn't
     */
    @Override public boolean isArtist(User user)
    {
        try
        {
            Artist artist = ArtistDAOImpl.getInstance().getArtistByName(user.getUsername());
            if(artist != null)
                return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method will make user 0 follow user
     * @param user0 the one who wants to follow
     * @param user the one followed
     */
    @Override public void follow(User user0, User user)
    {
        try
        {
            FollowDAOImpl.getInstance().Follow(user0,user);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method will make user 0 unfollow user
     * @param user0 the one who wants to unfollow
     * @param user the one unfollowed
     */
    @Override public void unfollow(User user0, User user)
    {
        try
        {
            FollowDAOImpl.getInstance().Unfollow(user0,user);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
