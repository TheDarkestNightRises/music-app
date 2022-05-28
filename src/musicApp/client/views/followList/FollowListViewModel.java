package musicApp.client.views.followList;

import musicApp.server.model.domainModel.User;

import java.util.List;

public class FollowListViewModel
{

  private MainModel model;

  public FollowListViewModel(MainModel model)
  {
    this.model = model;
  }

  public List<User> getFollowList()
  {
    User user = model.getLogInManager().getUser();
    return model.getFollowListManager().getFollowList(user);
  }

  public boolean isOnline(User user)
  {
    return model.getFollowListManager().isOnline(user);
  }
}
