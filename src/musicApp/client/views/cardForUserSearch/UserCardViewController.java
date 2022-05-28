package musicApp.client.views.cardForUserSearch;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.profile.ProfileViewModel;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;

import java.io.ByteArrayInputStream;

public class UserCardViewController implements ViewController {
    @FXML
    public ImageView profilePicture;
    @FXML
    public Label profileName;
    @FXML
    public Label description;

    private ViewHandler vh;
    private UserCardViewModel userCardViewModel;
    private User user;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.userCardViewModel = vmf.getUserCardViewModel();
        this.user = (User) args[0];
        userCardViewModel.bindName(profileName.textProperty());
        userCardViewModel.bindDescription(description.textProperty());
        userCardViewModel.bindImage(profilePicture.imageProperty());
        userCardViewModel.init(user);
    }

    @FXML
    public void openProfile() {
        if (userCardViewModel.isArtist(user)) {
            vh.openArtistProfile(user);
        } else {
            vh.openProfile(user);
        }
    }
}
