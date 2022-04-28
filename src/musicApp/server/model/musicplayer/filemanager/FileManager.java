package musicApp.server.model.musicplayer.filemanager;

import java.io.File;
import java.util.ArrayList;

public class FileManager {
    public ArrayList<File> getCurrentPlaylist() {
        ArrayList<File> songs = new ArrayList<>();
        File directory = new File("src/musicApp/server/serverData/Music");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                songs.add(file);
                System.out.println(file);
            }
        }
        return songs;
    }
}
