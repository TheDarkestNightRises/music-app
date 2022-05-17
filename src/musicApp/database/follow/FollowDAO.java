package musicApp.database.follow;

import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public interface FollowDAO
{
  ArrayList<User> getFollowList(User user);
  void Follow(User follower, User followed);
  void Unfollow(User follower, User followed);
  
}
