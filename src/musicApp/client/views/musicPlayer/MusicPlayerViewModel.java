package musicApp.client.views.musicPlayer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import musicApp.client.model.MainModel;
import musicApp.server.model.Playlist;
import musicApp.util.Subject;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.media.Media;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileInputStream;
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

    public MusicPlayerViewModel(MainModel mainModel) {
        this.mainModel = mainModel;
        songs = new ArrayList<>();
        songNumber = 0;
        support = new PropertyChangeSupport(this);
        currentSongLabel = new SimpleStringProperty();
        maxProperty = new SimpleDoubleProperty();
    }

    public void init(Object... args) {
        for (Object object : args) {
            playlist = (Playlist) object;
        }
        songs = mainModel.getMusicPlayerManager().getCurrentPlaylist();
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
        media = new Media(songs.get(songNumber).toURI().toString()); // TODO this should be in the controller
        currentSongLabel.set(songs.get(songNumber).getName());
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
}
