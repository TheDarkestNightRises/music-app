package musicApp.client.views.followList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.Contact;
import musicApp.server.model.domainModel.User;

import java.io.File;

public class ContactItemController implements ViewController
{

  @FXML private Label nickname;
  @FXML private ImageView status;

  public void setData(User user)
  {
    nickname.setText(user.getUsername());
    Image image = new Image(new File("src/musicApp/client/views/followList/offline.png").toURI().toString());
    status.setImage(image);
  }

  public void setOnline()
  {
    Image image = new Image(new File("src/musicApp/client/views/followList/online.png").toURI().toString());
    status.setImage(image);
  }

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Object... args)
  {

  }
}
