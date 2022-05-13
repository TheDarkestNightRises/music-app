package musicApp.client.network.profile;

import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;
import musicApp.shared.networking.RMIServer;

import java.util.ArrayList;

public interface ProfileClient {
    void setServer(RMIServer server);

    ArrayList<Playlist> fetchPlaylistsForUser(User user);

    ArrayList<Song> fetchSongsForPlaylist(Playlist playlist);
}
