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

public class ContactItemController implements ViewController
{

  @FXML private Label nickname;
  @FXML private ImageView status;
  private ContactItemViewModel contactItemViewModel;
  private ViewHandler viewHandler;
  private User user;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Object... args)
  {
   this.viewHandler = vh;
   this.user = (User) args[0];
   this.contactItemViewModel = vmf.getContactItemViewModel();
   setData(user);
  }
  public void setData(User user)
  {
    nickname.setText(user.getUsername());
    Image image = new Image(new File("src/musicApp/client/views/followList/offline.png").toURI().toString());
    status.setImage(image);
    if(userIsOnline(user))
      setOnline();
  }

  private boolean userIsOnline(User user)
  {
   return contactItemViewModel.isOnline(user);
  }

  public void setOnline()
  {
    Image image = new Image(new File("src/musicApp/client/views/followList/online.png").toURI().toString());
    status.setImage(image);
  }



  public void openProfile()
  {
    try
    {
      User user = UsersDAOImpl.getInstance().getUserByName(nickname.getText());
      if(isArtist(user))
        viewHandler.openArtistProfile(user);
           else
             viewHandler.openProfile(user);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }


  }

  public boolean isArtist(User user)
  {
    return contactItemViewModel.isArtist(user);
  }
}
