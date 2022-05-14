package musicApp.server.serverData.AlbumPictures;

import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.musicplayer.filemanager.FileManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    public FileInputStream fetchAlbumCover(String picturePath) {
        try {
            return new FileInputStream("src/musicApp/server/serverData/AlbumPictures/" + picturePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
