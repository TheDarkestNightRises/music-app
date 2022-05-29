package musicApp.client.views.followList;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.followList.FollowListManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.server.model.domainModel.User;

import java.io.File;

public class ContactItemViewModel
{
  private final ProfileManager profileManager;
  private final FollowListManager folowListManager;
  private SimpleStringProperty nicknameProperty;
  private SimpleObjectProperty<Image> statusProperty;


  public ContactItemViewModel(ProfileManager profileManager, FollowListManager followListManager) {
    this.profileManager = profileManager;
    this.folowListManager = followListManager;
    this.nicknameProperty = new SimpleStringProperty();
    this.statusProperty = new SimpleObjectProperty<>();
  }

  public boolean isArtist(User user)
  {
      return profileManager.isArtist(user);
  }

  public boolean isOnline(User user)
  {
    return folowListManager.isOnline(user);
  }

  public void bindNickname(StringProperty textProperty) {
    nicknameProperty.bindBidirectional(textProperty);
  }

  public void bindImage(ObjectProperty<Image> imageProperty) {
    statusProperty.bindBidirectional(imageProperty);
  }

  public void init(User user) {
    nicknameProperty.set(user.getUsername());
    Image image = new Image(new File("src/musicApp/client/views/followList/offline.png").toURI().toString());
    statusProperty.set(image);
    if (isOnline(user))
      setOnline();
  }

  public void setOnline() {
    Image image = new Image(new File("src/musicApp/client/views/followList/online.png").toURI().toString());
    statusProperty.set(image);
  }
}
