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

/**
 * viewModel for Add to playlist
 */
public class AddToPlaylistViewModel {
    private SimpleListProperty<String> playlistTitles;
    private AddToPlaylistManager addToPlaylistManager;
    private ProfileManager profileManager;
    private LogInManager loginManager;
    private ArrayList<Playlist> tempPlaylists;
    private Song currentSong;
    private StringProperty error;

    /**
     * constructor that initialises managers, properties and temporary playlists(of the logged in user)
     * @param addToPlaylistManager
     * @param profileManager
     * @param loginManager
     */
    public AddToPlaylistViewModel(AddToPlaylistManager addToPlaylistManager, ProfileManager profileManager,
                                  LogInManager loginManager) {
        this.addToPlaylistManager = addToPlaylistManager;
        this.profileManager = profileManager;
        this.loginManager = loginManager;
        playlistTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
        tempPlaylists = new ArrayList<>();
        error = new SimpleStringProperty("");
    }

    /**
     * resets the view to the initial state
     */
    public void reset() {
        playlistTitles.setAll(getPlaylistTitles());
        error.set("");
    }

    /**
     * returns the titles of the Arraylist of playlists created by the logged in user
     * @return titles
     */
    public ArrayList<String> getPlaylistTitles() {
        tempPlaylists = profileManager.fetchPlaylistsForUser(loginManager.getUser());
        ArrayList<String> titles = new ArrayList<>();
        if (tempPlaylists.size() != 0)
            for (int i = 0; i < tempPlaylists.size(); i++) {
                titles.add(tempPlaylists.get(i).getTitle());
            }
        return titles;
    }

    /**
     * binding for playlistTitles
     * @param property
     */
    public void bindList(ObjectProperty<ObservableList<String>> property) {
        property.bind(playlistTitles);
    }

    /**
     * delegates the method of adding the song to playlist in the position selectedIndex, to AddToPlaylistManager
     * catches exception if te song could not be added
     * @param selectedIndex
     */
    public void addToPlaylist(int selectedIndex) {
        try {
            addToPlaylistManager.addToPlaylist(loginManager.getUser(), tempPlaylists.get(selectedIndex), currentSong);
            error.set("Song has been added to playlist");
        } catch (Exception e) {
            error.set(e.getMessage());
        }
    }

    /**
     * setter for the song to be added in the playlist
     * @param song
     */
    public void setSong(Song song) {
        this.currentSong = song;
    }

    /**
     * binding for error
     * @param property
     */
    public void bindError(StringProperty property) {
        property.bind(error);
    }
}
