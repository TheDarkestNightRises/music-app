package musicApp.client.network.followList;

import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.util.List;

public interface FollowListClient
{
  void setServer(RMIServer server);
  List<User> getFollowList(User user);
}
