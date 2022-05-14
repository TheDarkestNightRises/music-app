package musicApp.server.model.musicplayer;

import javafx.scene.image.Image;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.musicplayer.filemanager.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
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
    public byte[] fetchAlbumCover(String picturePath) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        URL url = getClass().getResource("../../serverData/AlbumPictures/" + picturePath);
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
