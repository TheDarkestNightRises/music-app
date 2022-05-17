package musicApp.client.views.customControls;

import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class PlaylistTitleControl extends HBox {
    private HBox titleHBox;
    private Hyperlink button;

    private ArrayList<Song> songs;
    private ViewHandler viewHandler;

    public PlaylistTitleControl(ViewHandler viewHandler, ArrayList<Song> songs) {
        this.viewHandler = viewHandler;
        this.songs = songs;
        initCustomLook();
    }

    public void initCustomLook() {
        titleHBox = new HBox();
        titleHBox.setSpacing(10);
        if (songs.size() > 0) {
            button = new PlayButtonControl(viewHandler,songs);
            titleHBox.getChildren().add(button);
            System.out.println(button);
            this.getChildren().addAll(titleHBox,button);
            return;
        }
        System.out.println(button);
        this.getChildren().addAll(titleHBox);
    }
}
