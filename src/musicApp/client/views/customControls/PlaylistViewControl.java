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
        HBox containerHBox = new HBox();
        containerHBox.setAlignment(Pos.CENTER_LEFT);
        containerHBox.setPadding(new Insets(10));
        containerHBox.setSpacing(10);
        containerHBox.getChildren().add(playlistTitleText);
        fatherContainer.getChildren().add(containerHBox);
        VBox vBoxContainer = new VBox();
        fatherContainer.getChildren().add(vBoxContainer);
        new Thread(()->{
            System.out.println(songs);
            Platform.runLater(()->{
                vBoxContainer.getChildren().add(new SongsViewControl(songs,viewHandler));
                playlistTitleText.setText(playlist.getTitle());
                containerHBox.getChildren().add(new PlaylistTitleControl(viewHandler,songs));
            });
        }).start();
    }
}
