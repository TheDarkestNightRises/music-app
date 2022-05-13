package musicApp.server.model.profile;

import musicApp.server.model.Playlist;
import musicApp.server.model.User;

import java.util.ArrayList;

public interface ServerModelProfile {
    ArrayList<Playlist> fetchPlaylistsForUser(User user);
}
