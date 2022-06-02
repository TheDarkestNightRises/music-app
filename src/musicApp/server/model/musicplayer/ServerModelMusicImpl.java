package musicApp.server.model.musicplayer;

import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.server.serverData.filemanager.FileManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This is the server responsible for music
 */
public class ServerModelMusicImpl implements ServerModelMusic {
    private FileManager fileManager;
    private PropertyChangeSupport support;

    public ServerModelMusicImpl() {
        this.fileManager = FileManager.getInstance();

        this.support = new PropertyChangeSupport(this);
    }

    /**
     * This gets all the current playlist using the file manager
     * @param playlist to identify which one
     * @return songs
     */
    @Override
    public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) {
        return fileManager.getCurrentPlaylistFiles(playlist);
    }

    /**
     * This calls the file manager to fetch a photo
     * @param picturePath path to it
     * @return byte[] to picture
     */
    @Override
    public byte[] fetchAlbumCover(String picturePath) {
        return fileManager.fetchPhotoFromAlbum(picturePath);
    }

    /**
     * This method adds a song to the playlist liked songs. If the liked songs is not created then this
     * method will create the playlist. Delegates to dao to do the database interaction
     * @param user to add playlist
     * @param song to add
     */
    @Override
    public void addToLikedSongs(User user, Song song) {
        try {
            if (!UsersDAOImpl.getInstance().PlaylistExists(user, "Liked songs")) {
                PlaylistDAOImpl.getInstance().createPlayList("Liked songs", "Songs that I like", "", user);
                Playlist playlist = UsersDAOImpl.getInstance().getPlaylistIdFromUserByName(user, "Liked songs");
                support.firePropertyChange("newPlaylist", null, playlist);
            }
            Playlist playlist = UsersDAOImpl.getInstance().getPlaylistIdFromUserByName(user, "Liked songs");
            if (PlaylistDAOImpl.getInstance().songIsNotInThePlaylist(playlist, song)) {
                PlaylistDAOImpl.getInstance().insertSongIntoPlaylist(playlist, song);
                ArrayList<Song> songs = PlaylistDAOImpl.getInstance().getAllSongsFromPlayList(playlist);
                for (Song currentSong : songs) {
                    playlist.getSongs().add(currentSong);
                }
                System.out.println(playlist);
                support.firePropertyChange("newSongAddedToPlaylist", null, playlist);
                System.out.println("Fired from server model");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will remove a song from the liked songs playlist
     * @param user who called
     * @param song to remove
     */
    @Override
    public void removeToLikedSongs(User user, Song song) {
        try {
            Playlist playlist = UsersDAOImpl.getInstance().getPlaylistIdFromUserByName(user, "Liked songs");
            PlaylistDAOImpl.getInstance().removeSongFromPlaylist(playlist, song);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
