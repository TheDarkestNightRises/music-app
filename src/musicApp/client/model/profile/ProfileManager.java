package musicApp.client.model.profile;

import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;

import java.util.ArrayList;

public interface ProfileManager {
    ArrayList<Playlist> fetchPlaylistsForUser(User user);

    ArrayList<Song> fetchSongsForPlaylist(Playlist playlist);
}
