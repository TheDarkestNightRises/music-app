package musicApp.client.views.customControls;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class SongsViewControl extends VBox {
    private VBox vBoxContainer;
    private PlayButtonControl playButtonControl;
    private SongsHBoxControl songsHboxControl;

    private ArrayList<Song> songs;
    private ViewHandler viewHandler;

    public SongsViewControl(ArrayList<Song> songs, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.songs = songs;
        initCustomLook();
    }

    private void initCustomLook() {
        vBoxContainer = new VBox();
        vBoxContainer.setSpacing(10);
        vBoxContainer.setPadding(new Insets(10));
        Platform.runLater(() -> {
            if (songs.size() > 0) {
                playButtonControl = new PlayButtonControl(viewHandler, songs);
                songsHboxControl = new SongsHBoxControl(songs, viewHandler, vBoxContainer);
                getChildren().addAll(vBoxContainer, playButtonControl, songsHboxControl);
            }
        });
    }
}
