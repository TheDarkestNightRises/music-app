package musicApp.client.views.followList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.Contact;

public class ContactItemController implements ViewController
{

  @FXML
  private Label nickname;

  public void setData(Contact contact)
  {
  nickname.setText(contact.getUsername());
  }

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {

  }
}
