package musicApp.client.model.profile;

import musicApp.client.network.Client;
import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;

import java.util.ArrayList;

public class ProfileManagerImplementation implements ProfileManager{
    private Client client;

    public ProfileManagerImplementation(Client client) {
        this.client = client;
    }

    @Override
    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        return client.getProfileClient().fetchPlaylistsForUser(user);
    }

    @Override
    public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
        return client.getProfileClient().fetchSongsForPlaylist(playlist);
    }
}
