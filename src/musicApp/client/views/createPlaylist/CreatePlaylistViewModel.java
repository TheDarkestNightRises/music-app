package musicApp.client.views.createPlaylist;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import musicApp.client.model.createPlaylist.CreatePlaylistManager;
import musicApp.client.model.login.LogInManager;
import musicApp.server.model.domainModel.User;

/**
 * ViewModel for Create PLaylist
 */
public class CreatePlaylistViewModel {
    private final StringProperty title;
    private final StringProperty description;
    private final StringProperty error;
    private final CreatePlaylistManager createPlaylistManager;
    private final LogInManager loginManager;

    /**
     * constructor that initialises the managers and the properties
     * @param loginManager
     * @param createPlaylistManager
     */
    public CreatePlaylistViewModel(LogInManager loginManager, CreatePlaylistManager createPlaylistManager) {
        this.title = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
        this.loginManager = loginManager;
        this.createPlaylistManager = createPlaylistManager;
    }

    /**
     * delegates creation of playlist to the  CreatePlaylistManager and sets apropriate error message if creation was successful or not
     */
    public void createPlaylist() {
        try {
            createPlaylistManager.createPlaylist(title.get(), description.get(), loginManager.getUser());
            error.set("Playlist created successfully");
        } catch (Exception e) {
            error.set("" + e.getMessage());
            e.printStackTrace();
        }
    }

    public User fetchUser() {
        return loginManager.getUser();
    }

    /**
     * bidirectional binding for title
     * @param property
     */
    public void bindTitle(StringProperty property) {
        title.bindBidirectional(property);
    }

    /**
     * bidirectional binding for description
     * @param property
     */
    public void bindDescription(StringProperty property) {
        description.bindBidirectional(property);
    }

    /**
     * binding for error
     * @param property
     */
    public void bindError(StringProperty property) {
        property.bind(error);
    }

    public StringProperty getErrorProperty() {
        return error;
    }
}
