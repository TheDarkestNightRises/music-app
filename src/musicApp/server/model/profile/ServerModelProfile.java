package musicApp.server.model.profile;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public interface ServerModelProfile {
    ArrayList<Playlist> fetchPlaylistsForUser(User user);

    ArrayList<Song> fetchSongsForPlaylist(Playlist playlist);
}
