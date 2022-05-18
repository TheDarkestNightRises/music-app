package musicApp.client.views.customControls;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.net.URL;
import java.util.ArrayList;

public class PlayButtonControl extends Hyperlink {
    private Hyperlink button;
    private ImageView imageView;

    private final ArrayList<Song> songs;
    private TextField textField;
    private ViewHandler viewHandler;

    public PlayButtonControl(ViewHandler viewHandler, ArrayList<Song> songs) {
        this.viewHandler = viewHandler;
        this.songs = songs;
        initCustomLook();
    }

    private void initButtonFunctionality() {
        button.setOnAction(event -> viewHandler.openMusicPlayer(new Playlist(songs)));
    }

    private void initCustomLook() {
        button = new Hyperlink();
        URL url = getClass().getResource("../img/ic_play.png");
        Image image = new Image(String.valueOf(url));
        System.out.println(image);
        imageView = new ImageView(image);
        button.setGraphic(imageView);
        initButtonFunctionality();
    }

    public Hyperlink getButton() {
        return button;
    }
}
