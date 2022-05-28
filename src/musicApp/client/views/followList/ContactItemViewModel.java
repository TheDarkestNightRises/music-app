package musicApp.client.views.followList;

import musicApp.client.model.MainModel;
import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;

public class ContactItemViewModel
{
  private MainModel model;

  public ContactItemViewModel(MainModel model)
  {
    this.model = model;
  }

  public boolean isArtist(User user)
  {
      return model.getProfileManager().isArtist(user);
  }

  public boolean isOnline(User user)
  {
    return model.getFollowListManager().isOnline(user);
  }
}
