package musicApp.client.views.followList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.model.MainModel;
import musicApp.database.follow.FollowDAOImpl;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.Contact;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.login.ServerModelLoginImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FollowListController implements ViewController
{
  private ViewHandler vh;
  private FollowListViewModel viewModel;
  @FXML protected VBox contactsLayout;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Object... args)
  {
    this.vh = vh;
    this.viewModel = vmf.getFollowListViewModel();
    List<User> list = new ArrayList<>(contacts());
    initFollowers(list);

  }

  @FXML protected void openChat()
  {
    vh.openLog();
  }

  public void initFollowers(List<User> list)
  {
    for (User user : list)
    {
      HBox hBox = vh.openContact(user);
      contactsLayout.getChildren().add(hBox);
    }
  }

  private List<User> contacts()
  {
  return viewModel.getFollowList();
  }

  private boolean userIsOnline(User user)
  {
   return viewModel.isOnline(user);
  }
}
