package musicApp.client.views.customControls;

import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class SongsHBoxControl extends HBox {
    private int counterUntilSpace;
    private HBox hBox;
    private VBox fatherContainer;
    private HashMap<Song, VBox> songsView;

    private ArrayList<Song> songs;
    private Playlist playlist;
    private ViewHandler viewHandler;

    public SongsHBoxControl(ArrayList<Song> songs, Playlist playlist, ViewHandler viewHandler, VBox vBox) {
        this.viewHandler = viewHandler;
        this.songs = songs;
        this.fatherContainer = vBox;
        this.hBox = new HBox();
        this.songsView = new HashMap<>();
        this.playlist = playlist;
        initCustomLook();
    }

    private void initCustomLook() {
        makeNewHBox();
        counterUntilSpace = 0;
        Platform.runLater(() -> {
            for (Song song : songs) {
                addSongView(song);
            }
        });
    }

    private void makeNewHBox() {
        hBox = new HBox();
        hBox.setSpacing(10);
        fatherContainer.getChildren().add(hBox);
    }

    private void addSongView(Song song) {
        counterUntilSpace++;
        if (counterUntilSpace == 5) {
            counterUntilSpace = 0;
            makeNewHBox();
        }
        VBox songViewVbox = viewHandler.openSongView(song);
        hBox.getChildren().add(songViewVbox);
    }

    public void onNewSong(PropertyChangeEvent event) {
        System.out.println("GUI updates");
        Playlist playlist = (Playlist) event.getNewValue();
        System.out.println(playlist);
        if (this.playlist.getPlaylist_id() != playlist.getPlaylist_id()) {
            System.out.println("Wrong playlist");
            return;
        }
        ArrayList<Song> songs = playlist.getSongs();
        Song lastSong = songs.get(songs.size() - 1);
        addSongView(lastSong);
    }

    public void onRemovedSong(PropertyChangeEvent event) {
        Song song = (Song) event.getNewValue();
        VBox vBoxForSong = songsView.get(song);
        vBoxForSong.getChildren().removeAll();
    }
}
