package musicApp.server.serverData.AlbumPictures;

import javafx.scene.image.Image;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.musicplayer.filemanager.FileManager;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class ServerModelMusicImpl implements ServerModelMusic {
    private FileManager fileManager;

    public ServerModelMusicImpl() {
        this.fileManager = new FileManager();
    }

    @Override
    public ArrayList<File> getCurrentPlaylist() {
        return fileManager.getCurrentPlaylist();
    }

    @Override
    public Image fetchAlbumCover(String picturePath) {
        System.out.println(picturePath);
        URL url = getClass().getResource(picturePath);
        return new Image(String.valueOf(url));
    }
}
