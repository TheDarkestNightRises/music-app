package musicApp.client.views.customControls;

import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewHandler;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfileCardVboxControl extends VBox {
    private VBox fatherContainer;
    private ArrayList<User> users;
    private ViewHandler viewHandler;

    public ProfileCardVboxControl(ArrayList<User> users, ViewHandler viewHandler, VBox vBox) {
        this.viewHandler = viewHandler;
        this.users = users;
        this.fatherContainer = vBox;
        initCustomLook();
    }

    private void initCustomLook() {
        for (User user: users) {
            HBox userCard = viewHandler.openProfileCardView(user);
            fatherContainer.getChildren().add(userCard);
        }
    }
}
