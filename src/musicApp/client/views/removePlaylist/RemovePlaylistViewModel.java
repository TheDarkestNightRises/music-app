package musicApp.client.views.removePlaylist;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.client.model.removePlaylist.RemovePlaylistManager;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

/**
 * Remove album view model responsible for removing a playlist from the system
 */
public class RemovePlaylistViewModel {

    private final SimpleListProperty<String> playlistTitles;
    private final RemovePlaylistManager removePlaylistManager;
    private final LogInManager loginManager;
    private final ProfileManager profileManager;
    private ArrayList<Playlist> tempPlaylist;
    private StringProperty error;


    /**
     * This is the constructor of the RemoveAlbumViewModel
     * @param profileManager to fetch the artist albums
     * @param loginManager to get the current user
     * @param removePlaylistManager to delete the album
     */
    public RemovePlaylistViewModel(ProfileManager profileManager, RemovePlaylistManager removePlaylistManager,
                                   LogInManager loginManager) {
        this.removePlaylistManager = removePlaylistManager;
        this.loginManager = loginManager;
        this.profileManager = profileManager;
        playlistTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
        tempPlaylist = new ArrayList<>();
        error = new SimpleStringProperty("");
    }



    /**
     * This is used to reinitialize a playlist once a change is made
     */
    public void reset() {
        playlistTitles.setAll(getPlaylistTitles());
        error.set("");
    }


    /**
     * This method is used to create a list with all the playlist titles
     * @return the titles of all playlist from the current artist
     */
    public ArrayList<String> getPlaylistTitles() {
        User user = loginManager.getUser();
        tempPlaylist = profileManager.fetchPlaylistsForUser(user);
        ArrayList<String> titles = new ArrayList<>();
        if (tempPlaylist.size() != 0)
            for (int i = 0; i < tempPlaylist.size(); i++) {
                titles.add(tempPlaylist.get(i).getTitle());
            }
        return titles;
    }

    /**
     * This method is used to remove an playlist by selecting one
     * @param selectedIndex is the index of the selected playlist
     */
    public void removePlaylist(int selectedIndex) {
        try {
            Playlist playlist = tempPlaylist.get(selectedIndex);
            removePlaylistManager.deletePlaylist(playlist);
            error.set("The playlist has been removed!");
            playlistTitles.remove(selectedIndex);
        } catch (Exception e) {
            error.set(e.getMessage());
        }
    }

    public void bindError(StringProperty property) {
        property.bind(error);
    }

    public void bindList(ObjectProperty<ObservableList<String>> property) {
        property.bind(playlistTitles);
    }
}
