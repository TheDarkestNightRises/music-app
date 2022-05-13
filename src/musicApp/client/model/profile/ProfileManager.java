package musicApp.client.model.profile;

import musicApp.server.model.Playlist;
import musicApp.server.model.User;

import java.util.ArrayList;

public interface ProfileManager {
    ArrayList<Playlist> fetchPlaylistsForUser(User user);
}
