package musicApp.client.views.followList;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;
import java.util.List;

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
