package musicApp.server.model.profile;

import musicApp.database.artist.ArtistDAOImpl;
import musicApp.database.follow.FollowDAOImpl;
import musicApp.server.model.domainModel.*;
import musicApp.server.serverData.filemanager.FileManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelProfileImpl implements ServerModelProfile {
    private FileManager fileManager;

    public ServerModelProfileImpl() {
        this.fileManager = FileManager.getInstance();
    }

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

    @Override
    public byte[] fetchProfilePicture(String profile_picture) {
        System.out.println(profile_picture);
        return fileManager.fetchPhotoFromProfile(profile_picture);
    }

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
