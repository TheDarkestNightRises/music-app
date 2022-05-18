package musicApp.server.model.musicplayer;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.serverData.filemanager.FileManager;

import java.io.*;
import java.util.ArrayList;

public class ServerModelMusicImpl implements ServerModelMusic {
    private FileManager fileManager;

    public ServerModelMusicImpl() {
        this.fileManager = FileManager.getInstance();
    }

    @Override
    public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) {
        return fileManager.getCurrentPlaylistFiles(playlist);
    }

    @Override
    public byte[] fetchAlbumCover(String picturePath) {
        return fileManager.fetchPhotoFromAlbum(picturePath);
    }
}
