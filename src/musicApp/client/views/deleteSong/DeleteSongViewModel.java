package musicApp.client.views.deleteSong;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import musicApp.client.model.deleteSong.DeleteSongManager;
import musicApp.client.model.login.LogInManager;

import java.util.Optional;

/**
 * View model for Delete Song
 */
public class DeleteSongViewModel {

    private final StringProperty error;
    private final SimpleListProperty<String> songTitles;
    private final LogInManager loginManager;
    private final DeleteSongManager deleteSongManager;

    /**
     * constructor that initialises the view handler, the view model, the managers and the properties
     * @param loginManager
     * @param deleteSongManager
     */
    public DeleteSongViewModel(LogInManager loginManager, DeleteSongManager deleteSongManager) {
        this.loginManager = loginManager;
        this.deleteSongManager = deleteSongManager;
        this.error = new SimpleStringProperty("");
        songTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    /**
     * resets the view to its initial state, displaying a list with the songs of the currently logged in artist
     */
    public void reset() {
        error.set("");
        try {
            songTitles.setAll(deleteSongManager.getArtistSongsTitles(loginManager.getUser()));//TODO
        } catch (Exception e) {
            e.printStackTrace();
            error.set("Could not retrieve songs from server");
        }
    }

    public void bindError(StringProperty property) {
        error.bindBidirectional(property);
    }

    public void bindList(ObjectProperty<ObservableList<String>> property) {
        property.bind(songTitles);
    }

    /**
     * asks for confirmation on deletion of song  and delegates deletion of song to the DeleteSongManager
     * @param selectedIndex
     * @return
     */
    public boolean deleteSong(int selectedIndex) {

        if (selectedIndex < 0) {
            error.set("Please select a song");
            return false;
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure that you want to delete this song?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    deleteSongManager.deleteSong(selectedIndex);
                    error.set("Song deleted successfully");
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }
}
