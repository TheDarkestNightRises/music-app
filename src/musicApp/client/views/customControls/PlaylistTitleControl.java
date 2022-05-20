package musicApp.client.views.customControls;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class PlaylistTitleControl extends HBox {
    private HBox titleHBox;
    private LoadingTextControl loadingTextControl;
    private Hyperlink button;

    private ArrayList<Song> songs;
    private ViewHandler viewHandler;
    private Playlist playlist;

    public PlaylistTitleControl(ViewHandler viewHandler, ArrayList<Song> songs,Playlist playlist) {
        this.viewHandler = viewHandler;
        this.songs = songs;
        this.playlist = playlist;
        initCustomLook();
    }

    public void initCustomLook() {
        titleHBox = new HBox();
        titleHBox.setSpacing(10);
        titleHBox.setAlignment(Pos.CENTER_LEFT);
        loadingTextControl = new LoadingTextControl();
        loadingTextControl.setTextForLoading(playlist.getTitle());
        if (songs.size() > 0) {
            PlayButtonControl playButtonControl = new PlayButtonControl(viewHandler,songs);
            titleHBox.getChildren().addAll(loadingTextControl.getTextFromControl(),playButtonControl.getButton());
            this.getChildren().addAll(titleHBox);
            return;
        }
        titleHBox.getChildren().add(loadingTextControl.getTextFromControl());
        this.getChildren().addAll(titleHBox);
    }

    public void onNewSong(PropertyChangeEvent event) {

    }

    public void onRemovedSong(PropertyChangeEvent event) {
    }
}
