package musicApp.client.views.followList;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.server.model.domainModel.User;

import java.io.File;

public class ContactItemViewModel
{
  private SimpleStringProperty nicknameProperty;
  private SimpleObjectProperty<Image> statusProperty;

  private MainModel model;

  public ContactItemViewModel(MainModel model)
  {
    this.model = model;
    this.nicknameProperty = new SimpleStringProperty();
    this.statusProperty = new SimpleObjectProperty<>();
  }

  public boolean isArtist(User user)
  {
      return model.getProfileManager().isArtist(user);
  }

  public boolean isOnline(User user)
  {
    return model.getFollowListManager().isOnline(user);
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
