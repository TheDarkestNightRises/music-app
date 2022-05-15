package musicApp.client.views.musicPlayer;

import javafx.beans.property.*;
import javafx.scene.image.Image;
import musicApp.client.model.MainModel;
import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.util.Subject;
import javafx.scene.media.Media;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

public class MusicPlayerViewModel implements Subject {
    private final MainModel mainModel;
    private int songNumber;

    private Media media;
    private ArrayList<File> songs; //TODO: ARRAYLIST OF SONGS
    private Playlist playlist;

    private SimpleStringProperty currentSongLabel;
    private SimpleDoubleProperty maxProperty;
    private PropertyChangeSupport support;
    private ObjectProperty<Image> albumPicture;

    public MusicPlayerViewModel(MainModel mainModel) {
        this.mainModel = mainModel;
        songs = new ArrayList<>();
        songNumber = 0;
        support = new PropertyChangeSupport(this);
        currentSongLabel = new SimpleStringProperty();
        maxProperty = new SimpleDoubleProperty();
        albumPicture = new SimpleObjectProperty<>();
    }

    public void init(Object... args) {
        for (Object object : args) {
            playlist = (Playlist) object;
        }
        songs = mainModel.getMusicPlayerManager().getCurrentPlaylistFiles(playlist);
        changeSong();
    }

    public void previousMedia() {
        if (songNumber > 0) {
            songNumber--;
        } else {
            songNumber = songs.size() - 1;
        }
        changeSong();
    }

    public void nextMedia() {
        if (songNumber < songs.size() - 1) {
            songNumber++;
        } else {
            songNumber = 0;
        }
        changeSong();
    }

    public void changeSong() {
        Song currentSong = playlist.getSong(songNumber);
        media = new Media(songs.get(songNumber).toURI().toString()); // TODO this should be in the controller
        Image image = new Image(new ByteArrayInputStream(fetchAlbumCover(currentSong.getAlbum().getPicturePath())));
        albumPicture.set(image);
        currentSongLabel.set(currentSong.getArtist().getName()  + " - " +  currentSong.getTitle());
        support.firePropertyChange("ChangedSong", null, media);
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
        return mainModel.getMusicPlayerManager().fetchAlbumCover(picturePath);
    }

    public void bindImage(ObjectProperty<Image> property)
    {
        albumPicture.bindBidirectional(property);
    }
}
