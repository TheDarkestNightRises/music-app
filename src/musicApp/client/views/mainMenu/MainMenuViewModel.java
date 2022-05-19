package musicApp.client.views.mainMenu;

import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class MainMenuViewModel {
    private final MainModel mainModel;

    public MainMenuViewModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public ArrayList<Song> fetchRandomSongs() {
        return mainModel.getMainMenuManager().fetchRandomSongs();
    }
}
