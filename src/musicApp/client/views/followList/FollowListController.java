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

/**
 *This is the controller for follow list view
 */
public class FollowListController implements ViewController
{
  private ViewHandler vh;
  private FollowListViewModel viewModel;
  @FXML protected VBox contactsLayout;

  /**
   * The constructor of this controller. It calls the view model to do bindings
   * @param vh
   * @param vmf
   * @param args
   */
  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Object... args)
  {
    this.vh = vh;
    this.viewModel = vmf.getFollowListViewModel();
    List<User> list = new ArrayList<>(contacts());
    initFollowers(list);

  }

  /**
   * this method opens the chat view
   */
  @FXML protected void openChat()
  {
    vh.openLog();
  }

  /**
   * this method is used to display people followed
   * @param list
   */
  public void initFollowers(List<User> list)
  {
    for (User user : list)
    {
      HBox hBox = vh.openContact(user);
      contactsLayout.getChildren().add(hBox);
    }
  }

  /**
   * this methos is used to get the follow list;
   * @return a list with all followed people
   */
  private List<User> contacts()
  {
  return viewModel.getFollowList();
  }

  /**
   * this method is used to check is the user is online
   * @param user the user that is checked
   * @return true if the user is online and false if he is not
   */
  private boolean userIsOnline(User user)
  {
   return viewModel.isOnline(user);
  }
}
