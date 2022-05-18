package musicApp.client.model.followList;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.User;

import java.beans.PropertyChangeSupport;
import java.util.List;

public class FollowListManagerImplementation implements FollowListManager
{

  private Client client;


  public FollowListManagerImplementation(Client client) {
    this.client = client;
  }

  @Override public List<User> getFollowList(User user)
  {
   return client.getFollowListClient().getFollowList(user);
  }

  @Override public boolean isOnline(User user)
  {
    return client.getFollowListClient().isOnline(user);
  }
}
