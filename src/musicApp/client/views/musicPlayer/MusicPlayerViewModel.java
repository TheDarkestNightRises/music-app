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
    private SimpleStringProperty lyrics;



    public MusicPlayerViewModel(LogInManager loginManager, MusicManager musicManager) {
        this.loginManager = loginManager;
        this.musicManager = musicManager;
        songs = new ArrayList<>();
        songNumber = 0;
        support = new PropertyChangeSupport(this);
        currentSongLabel = new SimpleStringProperty();
        maxProperty = new SimpleDoubleProperty();
        albumPicture = new SimpleObjectProperty<>();
        lyrics = new SimpleStringProperty();
    }

    public void init(Object... args) {
        playlist = (Playlist) args[0];
        songs = musicManager.getCurrentPlaylistFiles(playlist);
        songNumber = 0;
        currentSong();
    }

    public File previousMedia() {
        if (songNumber > 0) {
            songNumber--;
        } else {
            songNumber = songs.size() - 1;
        }
        return currentSong();
    }

    public File nextMedia() {
        if (songNumber < songs.size() - 1) {
            songNumber++;
        } else {
            songNumber = 0;
        }
        return currentSong();
    }

    public File currentSong() {
        Song currentSong = playlist.getSong(songNumber);
        Image image = new Image(new ByteArrayInputStream(fetchAlbumCover(currentSong.getAlbum().getPicturePath())));
        albumPicture.set(image);
        currentSongLabel.set(currentSong.getArtist().getName() + " - " + currentSong.getTitle());
        String lyricsText = musicManager.fetchLyrics(currentSong.getArtist().getNickname(),currentSong.getTitle());
        lyrics.set(lyricsText);
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

    public byte[] fetchAlbumCover(String picturePath) {
        return musicManager.fetchAlbumCover(picturePath);
    }

    public void bindImage(ObjectProperty<Image> property) {
        albumPicture.bindBidirectional(property);
    }

    public void bindLyrics(StringProperty simpleStringProperty) {
        lyrics.bindBidirectional(simpleStringProperty);
    }

    public void addToLikedSongs() {
        User user = loginManager.getUser();
        Song song = playlist.getSong(songNumber);
       musicManager.addToLikedSongs(user, song);
    }

    public void removeToLikedSongs() {
        User user = loginManager.getUser();
        Song song = playlist.getSong(songNumber);
        musicManager.removeToLikedSongs(user, song);
    }

    public Song fetchCurrentSong() {
        return playlist.getSong(songNumber);
    }
}
