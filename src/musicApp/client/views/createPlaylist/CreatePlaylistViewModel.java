package musicApp.client.views.createPlaylist;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import musicApp.client.model.createPlaylist.CreatePlaylistManager;
import musicApp.client.model.login.LogInManager;
import musicApp.server.model.domainModel.User;

public class CreatePlaylistViewModel {
    private final StringProperty title;
    private final StringProperty description;
    private final StringProperty error;
    private final CreatePlaylistManager createPlaylistManager;
    private final LogInManager loginManager;


    public CreatePlaylistViewModel(LogInManager loginManager, CreatePlaylistManager createPlaylistManager) {
        this.title = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
        this.loginManager = loginManager;
        this.createPlaylistManager = createPlaylistManager;
    }

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

    public void bindTitle(StringProperty property) {
        title.bindBidirectional(property);
    }

    public void bindDescription(StringProperty property) {
        description.bindBidirectional(property);
    }

    public void bindError(StringProperty property) {
        property.bind(error);
    }

    public StringProperty getErrorProperty() {
        return error;
    }
}
