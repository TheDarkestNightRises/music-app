package musicApp.client.views.profileCard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.profile.ProfileViewModel;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.User;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class ProfileCardViewController implements ViewController {
    @FXML
    public ImageView profilePicture;
    @FXML
    public Label profileName;

    private ViewHandler vh;
    private ProfileViewModel profileViewModel;
    private User user;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.profileViewModel = vmf.getProfileViewModel();
        initCardProfileInfo();
    }

    private void initCardProfileInfo() {
        user = profileViewModel.fetchUser();
        profileName.setText(user.getUsername());
        Image image = new Image(new ByteArrayInputStream(profileViewModel.fetchProfilePicture(user.getProfile_picture())));
        profilePicture.setImage(image); //todo:bindings
    }

    @FXML
    public void openProfile() {
        vh.openProfile(user);
    }
}
