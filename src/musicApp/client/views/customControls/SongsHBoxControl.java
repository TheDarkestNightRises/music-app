package musicApp.client.views.customControls;

import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Song;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class SongsHBoxControl extends HBox {
    private int counterUntilSpace;
    private HBox hBox;
    private VBox fatherContainer;
    private HashMap<Song,VBox> songsView;

    private ArrayList<Song> songs;
    private ViewHandler viewHandler;

    public SongsHBoxControl(ArrayList<Song> songs, ViewHandler viewHandler,VBox vBox) {
        this.viewHandler = viewHandler;
        this.songs = songs;
        this.fatherContainer = vBox;
        this.hBox = new HBox();
        initCustomLook();
    }

    private void initCustomLook() {
        hBox = new HBox();
        hBox.setSpacing(10);
        counterUntilSpace = 0;
        Platform.runLater(()->{
            for (Song song : songs) {
                counterUntilSpace++;
                VBox songViewVbox = viewHandler.openSongView(song);
                songsView.put(song,songViewVbox);
                hBox.getChildren().add(songViewVbox);
                if (counterUntilSpace == 4) {
                    makeNewHBox();
                }
            }
            fatherContainer.getChildren().add(hBox);
        });
    }

    private void makeNewHBox() {
        fatherContainer.getChildren().add(hBox);
        hBox = new HBox();
        hBox.setSpacing(10);
    }

    public void onNewSong(PropertyChangeEvent event) {
    }

    public void onRemovedSong(PropertyChangeEvent event) {
        Song song = (Song) event.getNewValue();
        VBox vBoxForSong = songsView.get(song);
        vBoxForSong.getChildren().removeAll();
    }
}
