package musicApp.client.model.music;

import javafx.scene.image.Image;
import musicApp.client.network.Client;

import java.io.File;
import java.util.ArrayList;

public class MusicManagerImplementation implements MusicManager {
    private  Client client;

    public MusicManagerImplementation(Client client) {
        this.client = client;
    }

    @Override
    public ArrayList<File> getCurrentPlaylist() {
        return client.getMusicPlayerClient().getCurrentPlaylist();
    }

    @Override
    public Image fetchAlbumCover(String picturePath) {
        return client.getMusicPlayerClient().fetchAlbumCover(picturePath);
    }
}
