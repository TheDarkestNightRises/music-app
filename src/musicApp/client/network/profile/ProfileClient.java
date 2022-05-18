package musicApp.client.network.profile;

import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.util.ArrayList;

public interface ProfileClient {
    void setServer(RMIServer server);

    ArrayList<Playlist> fetchPlaylistsForUser(User user);

    ArrayList<Song> fetchSongsForPlaylist(Playlist playlist);

    byte[] fetchProfilePicture(String profile_picture);
}
