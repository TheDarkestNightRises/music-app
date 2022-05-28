package musicApp.client.views.cardForUserSearch;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;

import java.io.ByteArrayInputStream;

public class UserCardViewModel {
    private StringProperty nameProperty;
    private StringProperty descriptionProperty;
    private ObjectProperty<Image> profilePicture;
    private final MainModel mainModel;

    public UserCardViewModel(MainModel mainModel) {
        this.nameProperty = new SimpleStringProperty();
        this.descriptionProperty = new SimpleStringProperty();
        this.profilePicture = new SimpleObjectProperty<>();
        this.mainModel = mainModel;
    }

    public void init(User user) {
        nameProperty.set(user.getUsername());
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mainModel.getProfileManager().fetchProfilePicture(user.getProfile_picture()));
        Image image = new Image(byteArrayInputStream);
        profilePicture.set(image);
        descriptionProperty.set(user.getDescription());
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

    public boolean isArtist(User user) {
        return mainModel.getProfileManager().isArtist(user);
    }
}
