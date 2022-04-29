package musicApp.client.views.followList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import musicApp.client.model.Contact;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactItemController implements Initializable
{

  @FXML
  private Label nickname;

  public void setData(Contact contact)
  {
  nickname.setText(contact.getUsername());
  }

  @Override public void initialize(URL url, ResourceBundle resourceBundle)
  {

  }
}
