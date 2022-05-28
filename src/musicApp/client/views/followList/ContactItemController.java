package musicApp.client.views.followList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.Contact;
import musicApp.server.model.domainModel.User;

import java.io.File;
import java.sql.SQLException;

public class ContactItemController implements ViewController {

    @FXML
    private Label nickname;
    @FXML
    private ImageView status;

    private ContactItemViewModel contactItemViewModel;
    private ViewHandler viewHandler;
    private User user;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        this.user = (User) args[0];
        this.contactItemViewModel = vmf.getContactItemViewModel();
        contactItemViewModel.bindNickname(nickname.textProperty());
        contactItemViewModel.bindImage(status.imageProperty());
        contactItemViewModel.init(user);
    }

    public void openProfile() {
        try {
            User user = UsersDAOImpl.getInstance().getUserByName(nickname.getText());
            if (isArtist(user))
                viewHandler.openArtistProfile(user);
            else
                viewHandler.openProfile(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public boolean isArtist(User user) {
        return contactItemViewModel.isArtist(user);
    }
}
