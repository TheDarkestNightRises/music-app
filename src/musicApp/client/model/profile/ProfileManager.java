package musicApp.client.model.profile;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

import java.util.ArrayList;

public interface ProfileManager extends Subject {
    ArrayList<Playlist> fetchPlaylistsForUser(User user);

    ArrayList<Song> fetchSongsForPlaylist(Playlist playlist);

    byte[] fetchProfilePicture(String profile_picture);

    ArrayList<Album> fetchArtistAlbums(User user);
}
