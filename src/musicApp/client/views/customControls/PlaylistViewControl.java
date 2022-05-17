package musicApp.client.views.customControls;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class PlaylistViewControl extends VBox {
    private VBox fatherContainer;
    private Text playlistTitleText;
    private HBox containerHBox;

    private final ViewHandler viewHandler;
    private final ArrayList<Song> songs;
    private Playlist playlist;

    public PlaylistViewControl(ArrayList<Song> songs, ViewHandler viewHandler,Playlist playlist,VBox fatherContainer) {
        this.fatherContainer = fatherContainer;
        this.viewHandler = viewHandler;
        this.songs = songs;
        this.playlist = playlist;
        initCustomLook();
    }

    private void initCustomLook() {
        playlistTitleText = new LoadingTextControl();
        fatherContainer.getChildren().add(playlistTitleText);
        new Thread(()->{
            System.out.println(songs);
            Platform.runLater(()->{
                fatherContainer.getChildren().add(new PlaylistTitleControl(viewHandler,songs,playlist));
                fatherContainer.getChildren().add(new SongsViewControl(songs,viewHandler));
            });
        }).start();
    }
}
