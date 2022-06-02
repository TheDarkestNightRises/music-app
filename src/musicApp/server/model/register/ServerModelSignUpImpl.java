package musicApp.server.model.register;

import musicApp.database.artist.ArtistDAO;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.server.model.domainModel.User;
import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerModelSignUpImpl implements ServerModelSignUp
{
  private PropertyChangeSupport support;
  private UsersDAO userDAO;
  private ArtistDAO artistDAO;

  public ServerModelSignUpImpl()
  {
    this.support = new PropertyChangeSupport(this);
  }

  /**
   * this method checks if the password has any digits in it
   * @param password this is the password that is checked
   * @return true if the password has no digits and false if it does
   */
  @Override public boolean noDigits(String password)
  {
    for (int i = 0; i < password.length(); i++)
      if (Character.isDigit(password.charAt(i)))
        return false;
    return true;
  }

  /**
   * this method checks if the password has no upper character in it
   * @param password this is the password that is checked
   * @return true if the password has no upper and false if it does
   */
  @Override public boolean noUpper(String password)
  {

    for (int i = 0; i < password.length(); i++)
      if (Character.isUpperCase(password.charAt(i)))
        return false;
    return true;
  }

  /**
   * This method checks if the email is invalid
   * @param email this is the email that is checked
   * @return true if is not and false it is matching
   */
  @Override public boolean emailNotValid(String email)
  {
    String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    if (matcher.matches())
      return false;
    return true;
  }

  /**
   * this methods checks if the username already exsits
   * @param username the usernames that needs to be checked
   * @return true if the username exists and false if it does not
   */
  @Override public boolean usernameExists(String username)
  {
    try
    {
      userDAO = new UsersDAOImpl();
      return userDAO.usernameExists(username);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * this method is used to create an artist type account
   * @param user this is used in the creation of an artist account since the artist is a user too
   */
  @Override public void addArtist(User user)
  {
    try
    {
      artistDAO = new ArtistDAOImpl();
      UsersDAOImpl.getInstance().createUser(user.getUsername(), user.getPassword(), user.getEmail());
      artistDAO.insertArtist(user.getUsername());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * This method is used to create a user account
   * @param username this is the username that the users will have
   * @param password this is the password that user will have
   * @param email this is the email that the user will have
   */
  @Override
  public void addUser(String username, String password, String email) {
    try
    {
      UsersDAOImpl.getInstance().createUser(username, password, email);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
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
