package musicApp.database.follow;

import musicApp.database.song.Song;
import musicApp.database.users.User;

import java.util.ArrayList;

public interface FollowDAO
{
  ArrayList<User> getFollowList(User user);
  void Follow(User user1, User user2);
  void Unfollow(User user1, User user2);
  
}
