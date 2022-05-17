package musicApp.client.views.profile;

import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public class ProfileViewModel {
    private MainModel mainModel;

    public ProfileViewModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        return mainModel.getProfileManager().fetchPlaylistsForUser(user);
    }

    public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
        return mainModel.getProfileManager().fetchSongsForPlaylist(playlist);
    }
}
