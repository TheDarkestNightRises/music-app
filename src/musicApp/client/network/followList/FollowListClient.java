package musicApp.client.network.followList;

import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.util.List;

public interface FollowListClient
{
  List<User> getFollowList(User user);
  boolean isOnline(User user);
}
