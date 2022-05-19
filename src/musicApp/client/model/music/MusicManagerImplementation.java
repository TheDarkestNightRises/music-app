package musicApp.client.model.music;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

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

    @Override public void addToLikedSongs(User user, Song song)
    {
        client.getMusicPlayerClient().addToLikedSongs(user, song);
    }

    @Override public void removeToLikedSongs(User user, Song song)
    {
        client.getMusicPlayerClient().removeToLikedSongs(user, song);
    }
}
