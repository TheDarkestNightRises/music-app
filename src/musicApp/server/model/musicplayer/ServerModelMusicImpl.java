package musicApp.server.model.musicplayer;

import musicApp.server.model.musicplayer.filemanager.FileManager;

import java.io.File;
import java.util.ArrayList;

public class ServerModelMusicImpl implements ServerModelMusic{
    private FileManager fileManager;

    public ServerModelMusicImpl() {
        this.fileManager = new FileManager();
    }

    @Override
    public ArrayList<File> getCurrentPlaylist() {
        return fileManager.getCurrentPlaylist();
    }
}
