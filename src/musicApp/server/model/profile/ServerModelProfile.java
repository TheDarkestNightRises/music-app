package musicApp.server.model.profile;

import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;

import java.util.ArrayList;

public interface ServerModelProfile {
    ArrayList<Playlist> fetchPlaylistsForUser(User user);

    ArrayList<Song> fetchSongsForPlaylist(Playlist playlist);
}
