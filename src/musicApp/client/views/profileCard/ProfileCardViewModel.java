package musicApp.client.views.profileCard;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.User;

import java.io.ByteArrayInputStream;

public class ProfileCardViewModel {
    private StringProperty nameProperty;
    private ObjectProperty<Image> profilePicture;
    private final MainModel mainModel;

    public ProfileCardViewModel(MainModel mainModel) {
        this.nameProperty = new SimpleStringProperty();
        this.profilePicture = new SimpleObjectProperty<>();
        this.mainModel = mainModel;
    }

    public void init(User user) {
        nameProperty.set(user.getUsername());
        Image image = new Image(new ByteArrayInputStream(mainModel.getProfileManager().fetchProfilePicture(user.getProfile_picture())));
        profilePicture.set(image);
    }

    public void bindName(StringProperty textProperty) {
        nameProperty.bindBidirectional(textProperty);
    }

    public void bindImage(ObjectProperty<Image> imageProperty) {
        profilePicture.bindBidirectional(imageProperty);
    }

    public boolean isArtist(User user) {
        return mainModel.getProfileManager().isArtist(user);
    }

    public User fetchUser() {
        return mainModel.getLogInManager().getUser();
    }
}
