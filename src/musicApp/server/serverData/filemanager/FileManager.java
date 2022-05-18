package musicApp.server.serverData.filemanager;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FileManager {
    public static FileManager instance;

    private FileManager() {
    }

    public synchronized static FileManager getInstance() {
        if (instance == null) {
            return new FileManager();
        }
        return instance;
    }

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

    public byte[] fetchPhotoFromProfile(String picturePath) {
        if(picturePath == null || picturePath.equals(""))
            picturePath = "default_pfp.jpg";
        String path = "../ProfilePictures/" + picturePath;
        System.out.println(path);
        return extractPhoto(path);
    }

    public byte[] fetchPhotoFromAlbum(String picturePath) {
        if(picturePath == null || picturePath.equals(""))
            picturePath = "default_album.png";
        String path = "../AlbumPictures/" + picturePath;
        System.out.println(path);
        return extractPhoto(path);
    }

    public byte[] extractPhoto(String picturePath) {
        System.out.println(picturePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        URL url = getClass().getResource(picturePath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(url);
            ImageIO.write((RenderedImage) image, "png", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
