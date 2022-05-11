package musicApp.server.model.login;

import musicApp.client.model.User;
import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerModelLoginImpl implements ServerModelLogin
{

  private List<User> userList;
  private PropertyChangeSupport support;
  private UsersDAO user;

  public ServerModelLoginImpl()
  {
    this.userList = new ArrayList<>();
    this.support = new PropertyChangeSupport(this);
  }

  @Override public boolean SignIn(User user)
  {
    try
    {
      for (User currentUser : userList)
        if (currentUser.isLoggedIn() && currentUser.getUsername()
            .equals(user.getUsername()))
          return false;
      if (this.user.accountExists(user.getUsername(), user.getPassword()))
      {
        user.setLoggedIn(true);
        System.out.println(user);
        userList.add(user);
        System.out.println(userList);
        return true;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  @Override public void disconnect(User user)
  {
    for (User currentUser : userList)
    {
      if (currentUser.getUsername().equals(user.getUsername()))
        currentUser.setLoggedIn(false);
    }
  }

  @Override public int getNumberOfUsers()
  {
    return userList.size();
  }

  @Override public boolean accountDoesNotExist(User user)
  {
    try
    {
      this.user = new UsersDAOImpl();
      if (!this.user.accountExists(user.getUsername(), user.getPassword()))
        return true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
