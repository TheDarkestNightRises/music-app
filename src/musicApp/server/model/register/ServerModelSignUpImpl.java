package musicApp.server.model.register;

import musicApp.database.Users.User;
import musicApp.database.Users.UsersDAO;
import musicApp.database.Users.UsersDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerModelSignUpImpl implements ServerModelSignUp
{
  private PropertyChangeSupport support;
  private UsersDAO d;


  public ServerModelSignUpImpl() {
    this.support = new PropertyChangeSupport(this);
  }

  @Override public boolean noDigits(String password)
  {
    for (int i = 0; i < password.length(); i++)
      if (Character.isDigit(password.charAt(i)))
        return false;
    return true;
  }

  @Override public boolean noUpper(String password)
  {

    for (int i = 0; i < password.length(); i++)
      if (Character.isUpperCase(password.charAt(i)))
        return false;
    return true;
  }

  @Override public boolean emailNotValid(String email)
  {
    String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    if(matcher.matches())
      return false;
    return true;
  }

  @Override public boolean usernameExists(String username)
  {
    try
    {
      d = new UsersDAOImpl();
      return d.usernameExists(username);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }


    @Override public void addUser(User user)
    {
      try
      {
        UsersDAO d = new UsersDAOImpl();
        d.createUser(user.getUsername(),user.getPassword(),user.getEmail());
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }


  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName,listener);
  }
}
