package musicApp.server.model.musicplayer.filemanager;

import musicApp.server.model.Playlist;
import musicApp.server.model.Song;

import java.io.File;
import java.util.ArrayList;

public class FileManager {
    public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) {
        ArrayList<File> songsFiles = new ArrayList<>();
        for (Song song:playlist.getSongs()) {
            String songFilePath = song.getFile_path();
            if (songFilePath != null) {
                File file = new File("src/musicApp/server/serverData/Music/" + songFilePath);
                songsFiles.add(file);
            }
        }
        return songsFiles;
    }
}
