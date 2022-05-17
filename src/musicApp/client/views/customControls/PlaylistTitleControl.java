package musicApp.client.views.customControls;

import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

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
        loadingTextControl = new LoadingTextControl();
        loadingTextControl.setTextForLoading(playlist.getTitle());
        if (songs.size() > 0) {
            button = new PlayButtonControl(viewHandler,songs);
            this.getChildren().addAll(loadingTextControl,button);
            return;
        }
        this.getChildren().addAll(loadingTextControl);
    }
}
