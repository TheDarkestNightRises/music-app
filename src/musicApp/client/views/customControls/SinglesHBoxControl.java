package musicApp.client.views.customControls;

import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class SinglesHBoxControl extends HBox {
    private int counterUntilSpace;
    private HBox hBox;
    private VBox fatherContainer;

    private ArrayList<Song> songs;
    private ViewHandler viewHandler;

    public SinglesHBoxControl(ArrayList<Song> songs, ViewHandler viewHandler, VBox vBox) {
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
                VBox songViewVbox = viewHandler.openSingleView(song);
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
}
