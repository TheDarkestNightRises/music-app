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
    private ProfileViewModel profileViewModel;
    private User user;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.profileViewModel = vmf.getProfileViewModel();
        this.user = (User) args[0];
        initCardProfileInfo();
    }

    private void initCardProfileInfo() {
        profileName.setText(user.getUsername());
        Image image = new Image(new ByteArrayInputStream(profileViewModel.fetchProfilePicture(user.getProfile_picture())));
        profilePicture.setImage(image);
        description.setText(user.getDescription());
    }

    @FXML
    public void openProfile() {
        if (user instanceof Artist) {
            vh.openArtistProfile(user);
        } else {
            vh.openProfile(user);
        }
    }
}
