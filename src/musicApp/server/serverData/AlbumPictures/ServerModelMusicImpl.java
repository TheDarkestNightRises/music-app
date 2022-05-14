package musicApp.server.serverData.AlbumPictures;

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
    public File fetchAlbumCover(String picturePath) {
        URL url = getClass().getResource(picturePath);
        File file = new File(String.valueOf(url));
        return new File(String.valueOf(url));
    }
}
