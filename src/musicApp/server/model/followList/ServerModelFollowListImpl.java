package musicApp.server.model.followList;

import musicApp.database.follow.FollowDAOImpl;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;
import java.util.List;

public class ServerModelFollowListImpl implements ServerModelFollowList
{
  @Override public List<User> getFollowList(User user)
  {
    try
    {
      return FollowDAOImpl.getInstance().getFollowList(user);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }


}
