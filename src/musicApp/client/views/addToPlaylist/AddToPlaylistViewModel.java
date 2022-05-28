package musicApp.client.views.addToPlaylist;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.addToPlaylist.AddToPlaylistManager;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;

import java.util.ArrayList;

public class AddToPlaylistViewModel {
    private SimpleListProperty<String> playlistTitles;
    private AddToPlaylistManager addToPlaylistManager;
    private ProfileManager profileManager;
    private LogInManager loginManager;
    private ArrayList<Playlist> tempPlaylists;
    private Song currentSong;
    private StringProperty error;

    public AddToPlaylistViewModel(AddToPlaylistManager addToPlaylistManager, ProfileManager profileManager,
                                  LogInManager loginManager) {
        this.addToPlaylistManager = addToPlaylistManager;
        this.profileManager = profileManager;
        this.loginManager = loginManager;
        playlistTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
        tempPlaylists = new ArrayList<>();
        error = new SimpleStringProperty("");
    }

    public void reset() {
        playlistTitles.setAll(getPlaylistTitles());
        error.set("");
    }

    public ArrayList<String> getPlaylistTitles() {
        tempPlaylists = profileManager.fetchPlaylistsForUser(loginManager.getUser());
        ArrayList<String> titles = new ArrayList<>();
        if (tempPlaylists.size() != 0)
            for (int i = 0; i < tempPlaylists.size(); i++) {
                titles.add(tempPlaylists.get(i).getTitle());
            }
        return titles;
    }

    public void bindList(ObjectProperty<ObservableList<String>> property) {
        property.bind(playlistTitles);
    }

    public void addToPlaylist(int selectedIndex) {
        try {
            addToPlaylistManager.addToPlaylist(loginManager.getUser(), tempPlaylists.get(selectedIndex), currentSong);
            error.set("Song has been added to playlist");
        } catch (Exception e) {
            error.set(e.getMessage());
        }
    }

    public void setSong(Song song) {
        this.currentSong = song;
    }

    public void bindError(StringProperty property) {
        property.bind(error);
    }
}
