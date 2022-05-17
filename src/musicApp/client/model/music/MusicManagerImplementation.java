package musicApp.client.model.music;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Playlist;

import java.io.File;
import java.util.ArrayList;

public class MusicManagerImplementation implements MusicManager {
    private  Client client;

    public MusicManagerImplementation(Client client) {
        this.client = client;
    }

    @Override
    public ArrayList<File> getCurrentPlaylistFiles(Playlist playlist) {
        return client.getMusicPlayerClient().getCurrentPlaylistFiles(playlist);
    }

    @Override
    public byte[] fetchAlbumCover(String picturePath) {
        return client.getMusicPlayerClient().fetchAlbumCover(picturePath);
    }
}
