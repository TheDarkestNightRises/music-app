package musicApp.client.views.profileCard;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.server.model.domainModel.User;

import java.io.ByteArrayInputStream;

public class ProfileCardViewModel {
    private final ProfileManager profileManager;
    private final LogInManager loginManager;
    private StringProperty nameProperty;
    private ObjectProperty<Image> profilePicture;

    public ProfileCardViewModel(ProfileManager profileManager, LogInManager loginManager) {
        this.profileManager = profileManager;
        this.loginManager = loginManager;
        this.nameProperty = new SimpleStringProperty();
        this.profilePicture = new SimpleObjectProperty<>();
    }

    public void init(User user) {
        nameProperty.set(user.getUsername());
        Image image = new Image(new ByteArrayInputStream(profileManager.fetchProfilePicture(user.getProfile_picture())));
        profilePicture.set(image);
    }

    public void bindName(StringProperty textProperty) {
        nameProperty.bindBidirectional(textProperty);
    }

    public void bindImage(ObjectProperty<Image> imageProperty) {
        profilePicture.bindBidirectional(imageProperty);
    }

    public boolean isArtist(User user) {
        return profileManager.isArtist(user);
    }

    public User fetchUser() {
        return loginManager.getUser();
    }
}
