package musicApp.client.model.followList;

import musicApp.server.model.domainModel.User;

import java.util.List;

public interface FollowListManager
{
  List<User> getFollowList(User user);
  boolean isOnline(User user);
}
