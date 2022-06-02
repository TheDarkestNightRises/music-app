package musicApp.server.model.followList;

import musicApp.database.follow.FollowDAOImpl;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;
import java.util.List;

public class ServerModelFollowListImpl implements ServerModelFollowList
{

  /**
   * this method is used to get the follow list
   * @param user this is the user from whom the follow list is provided
   * @return a list of users
   */
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
