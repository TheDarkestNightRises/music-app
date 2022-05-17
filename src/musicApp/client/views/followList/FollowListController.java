package musicApp.client.views.followList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.Contact;

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


  @Override public void init(ViewHandler vh, ViewModelFactory vmf,Object... args)
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

    Contact contact4 = new Contact();
    contact4.setUsername("Dan sezutus'");
    list.add(contact4);

    Contact contact5 = new Contact();
    contact5.setUsername("Dan sezutu'");
    list.add(contact5);

    Contact contact6 = new Contact();
    contact6.setUsername("Dan sezutu'");
    list.add(contact6);

    Contact contact7 = new Contact();
    contact7.setUsername("Dan sezutu'");
    list.add(contact7);

    Contact contact8 = new Contact();
    contact8.setUsername("Dan sezutu'");
    list.add(contact8);

    Contact contact9 = new Contact();
    contact9.setUsername("Dan sezutu'");
    list.add(contact9);

    Contact contact10 = new Contact();
    contact10.setUsername("Dan sezutu'");
    list.add(contact10);

    Contact contact11= new Contact();
    contact11.setUsername("Dan sezutu'");
    list.add(contact11);

    Contact contact12= new Contact();
    contact12.setUsername("Dan sezutu'");
    list.add(contact12);

    Contact contact13= new Contact();
    contact13.setUsername("Dan sezutu'");
    list.add(contact13);

    Contact contact14= new Contact();
    contact14.setUsername("Dan sezutu'");
    list.add(contact14);

    Contact contact15= new Contact();
    contact15.setUsername("Dan sezutu'");
    list.add(contact15);

    Contact contact16= new Contact();
    contact16.setUsername("Dan sezutu'");
    list.add(contact16);

    Contact contact17= new Contact();
    contact17.setUsername("Dan sezutu'");
    list.add(contact17);
    return  list;
  }
}
