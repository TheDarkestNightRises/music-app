package musicApp.client.views.musicPlayer;

import javafx.beans.property.*;
import javafx.scene.image.Image;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.music.MusicManager;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;
import javafx.scene.media.Media;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

/**
 * Music player view model responsible for managing the internal songs list and keeping track of
 * the current song number.
 */
public class MusicPlayerViewModel implements Subject {
    private final LogInManager loginManager;
    private final MusicManager musicManager;
    private int songNumber;
    private ArrayList<File> songs;
    private Playlist playlist;

    private SimpleStringProperty currentSongLabel;
    private SimpleDoubleProperty maxProperty;
    private PropertyChangeSupport support;
    private ObjectProperty<Image> albumPicture;


    /**
     * This is the constructor of the MusicPlayerViewModel
     * @param loginManager to get the current user
     * @param musicManager to fetch data from the server model(delegates)
     */
    public MusicPlayerViewModel(LogInManager loginManager, MusicManager musicManager) {
        this.loginManager = loginManager;
        this.musicManager = musicManager;
        songs = new ArrayList<>();
        songNumber = 0;
        support = new PropertyChangeSupport(this);
        currentSongLabel = new SimpleStringProperty();
        maxProperty = new SimpleDoubleProperty();
        albumPicture = new SimpleObjectProperty<>();

    }

    /**
     * Initialize view model with playlist and changes to the current song
     * @param args
     */
    public void init(Object... args) {
        playlist = (Playlist) args[0];
        songs = musicManager.getCurrentPlaylistFiles(playlist);
        songNumber = 0;
        currentSong();
    }

    /**
     * This method will fetch the previous song for the media player
      * @return the previous song file
     */
    public File previousMedia() {
        if (songNumber > 0) {
            songNumber--;
        } else {
            songNumber = songs.size() - 1;
        }
        return currentSong();
    }

    /**
     * This method will fetch the next song for the media player
     * @return the next song file
     */
    public File nextMedia() {
        if (songNumber < songs.size() - 1) {
            songNumber++;
        } else {
            songNumber = 0;
        }
        return currentSong();
    }

    /**
     * This method will change the appearance of the media player by changing the bindings here
     * and return the current song.
     * @return current song
     */
    public File currentSong() {
        Song currentSong = playlist.getSong(songNumber);
        Image image = new Image(new ByteArrayInputStream(fetchAlbumCover(currentSong.getAlbum().getPicturePath())));
        albumPicture.set(image);
        currentSongLabel.set(currentSong.getArtist().getName() + " - " + currentSong.getTitle());
        return songs.get(songNumber);
    }


    public SimpleStringProperty currentSongLabelProperty() {
        return currentSongLabel;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }


    public DoubleProperty getMaxProperty() {
        return maxProperty;
    }

    public void setMaximumDuration(double v) {
        maxProperty.set(v);
    }

    /**
     * This method will fetch the album cover for the current song
     * @param picturePath file path
     * @return byte array of the photo
     */
    public byte[] fetchAlbumCover(String picturePath) {
        return musicManager.fetchAlbumCover(picturePath);
    }

    public void bindImage(ObjectProperty<Image> property) {
        albumPicture.bindBidirectional(property);
    }

    /**
     * This method delegate responsibility to add a song from the liked playlist
     */
    public void addToLikedSongs() {
        User user = loginManager.getUser();
        Song song = playlist.getSong(songNumber);
       musicManager.addToLikedSongs(user, song);
    }

    /**
     * This method delegate responsibility to remove a song from the liked playlist
     */
    public void removeToLikedSongs() {
        User user = loginManager.getUser();
        Song song = playlist.getSong(songNumber);
        musicManager.removeToLikedSongs(user, song);
    }

    /**
     * This method will fetch the current song
     * @return Song
     */
    public Song fetchCurrentSong() {
        return playlist.getSong(songNumber);
    }
}
