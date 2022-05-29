package musicApp.client.views.profile;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class ProfileViewModel implements Subject {
    private final LogInManager loginManger;
    private final ProfileManager profileManager;
    private StringProperty nameProperty;
    private StringProperty descriptionProperty;
    private ObjectProperty<Image> profilePicture;

    private PropertyChangeSupport support;

    public ProfileViewModel(LogInManager loginManager, ProfileManager profileManager) {
        this.loginManger = loginManager;
        this.profileManager = profileManager;
        this.support = new PropertyChangeSupport(this);
        this.nameProperty = new SimpleStringProperty();
        this.descriptionProperty = new SimpleStringProperty();
        this.profilePicture = new SimpleObjectProperty<>();
        profileManager.addListener("newSongAddedToPlaylist", this::updatePlaylist);
        profileManager.addListener("newPlaylist", this::onNewPlaylist);
    }

    public void init(User user) {
        nameProperty.set(user.getUsername());
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fetchProfilePicture(user.getProfile_picture()));
        Image image = new Image(byteArrayInputStream);
        profilePicture.set(image);
        descriptionProperty.set(user.getDescription());
    }

    private void onNewPlaylist(PropertyChangeEvent event) {
        support.firePropertyChange("newPlaylist", null, event.getNewValue());
    }

    private void updatePlaylist(PropertyChangeEvent event) {
        System.out.println("Fired from profile view model");
        support.firePropertyChange("newSongAddedToPlaylist", null, event.getNewValue());
    }

    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        return profileManager.fetchPlaylistsForUser(user);
    }

    public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
        return profileManager.fetchSongsForPlaylist(playlist);
    }

    public byte[] fetchProfilePicture(String profile_picture) {
        return profileManager.fetchProfilePicture(profile_picture);
    }

    public User fetchUser() {
        return loginManger.getUser();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    public boolean isArtist(User user) {
        return profileManager.isArtist(user);
    }

    public void follow(User user) {
        User user0 = fetchUser();
        profileManager.follow(user0, user);
    }

    public void unfollow(User user) {
        User user0 = fetchUser();
        profileManager.unfollow(user0, user);
    }

    public void bindName(StringProperty textProperty) {
        nameProperty.bindBidirectional(textProperty);
    }

    public void bindDescription(StringProperty textProperty) {
        descriptionProperty.bindBidirectional(textProperty);
    }

    public void bindImage(ObjectProperty<Image> imageProperty) {
        profilePicture.bindBidirectional(imageProperty);
    }


}
