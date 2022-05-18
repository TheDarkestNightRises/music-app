package musicApp.server.model.followList;

import musicApp.server.model.domainModel.User;

import java.util.List;

public interface ServerModelFollowList
{
  List<User> getFollowList(User user);

}
