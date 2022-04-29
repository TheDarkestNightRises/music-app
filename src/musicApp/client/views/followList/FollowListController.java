package musicApp.client.views.followList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.model.Contact;
import musicApp.client.views.chat.ChatViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FollowListController implements ViewController, Initializable
{
  private ViewHandler vh;
  private FollowListViewModel viewModel;
  @FXML
  protected VBox contactsLayout;


  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.viewModel = vmf.getFollowListViewModel();
  }

  @FXML protected void openChat()
  {
    vh.openLog();
  }

  @Override public void initialize(URL url, ResourceBundle resourceBundle) //INIT > VIEW HANDLER.LOAD
  {
    List<Contact> list = new ArrayList<>(contacts());
   for(int i = 0; i < list.size(); i++)
   {
     FXMLLoader fxmlLoader = new FXMLLoader();
     fxmlLoader.setLocation(getClass().getResource("contact_item.fxml"));
     try
     {
       HBox hBox = fxmlLoader.load();
       ContactItemController c = fxmlLoader.getController();
       c.setData(list.get(i));
       contactsLayout.getChildren().add(hBox);
     }
     catch (IOException e)
     {
       e.printStackTrace();
     }
   }
  }

  private List<Contact> contacts()
  {
    List<Contact> list = new ArrayList<>();
    Contact contact1 = new Contact();
    contact1.setUsername("Ion Nebunaticu'");
    list.add(contact1);

    Contact contact2 = new Contact();
    contact2.setUsername("Dan spataru'");
    list.add(contact2);

    Contact contact3 = new Contact();
    contact3.setUsername("Dan sezutu'");
    list.add(contact3);
    return  list;
  }
}
