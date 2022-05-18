package musicApp.server.model.musicplayer;

import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.server.serverData.filemanager.FileManager;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelMusicImpl implements ServerModelMusic {
    private FileManager fileManager;

    public ServerModelMusicImpl() {
        this.fileManager = FileManager.getInstance();
    }

    @Override
    public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) {
        return fileManager.getCurrentPlaylistFiles(playlist);
    }

    @Override
    public byte[] fetchAlbumCover(String picturePath) {
        return fileManager.fetchPhotoFromAlbum(picturePath);
    }

    @Override public void addToLikedSongs(User user, Song song)
    {}
//        try
//        {
//            System.out.println(user.getUsername());
////            System.out.println(UsersDAOImpl.getInstance().getPlaylistFromUserByPlaylistName(user,"Liked songs"));
//
////         {
//////             PlaylistDAOImpl.getInstance().createPlayList("Liked songs", "Songs that I have liked", "", user);
////         }
////        }
////        catch (SQLException e)
////        {
////            e.printStackTrace();
////        }
//    }}

    @Override public void removeToLikedSongs(User user)
    {

    }
}
