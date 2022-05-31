package musicApp.client.model.register;

import musicApp.client.network.Client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class SignUpManagerImplementation implements SignUpManager
{
  private Client client;
  private PropertyChangeSupport support;

  public SignUpManagerImplementation(Client client) {
    this.client = client;
    this.support = new PropertyChangeSupport(this);
    client.addListener("OnNewUserEntry", this::onNewUserEntry);
  }

  private void onNewUserEntry(PropertyChangeEvent event) {
    support.firePropertyChange(event);
  }

  @Override public void addUser(String username, String password, String email)
  {
    client.getSignUpClient().addUser(username, password, email);
  }

  @Override public boolean emailNotValid(String email)
  {
    return client.getSignUpClient().emailNotValid(email);
  }

  @Override public void addArtist(String username, String password, String email)
  {
    client.getSignUpClient().addArtist(username, password, email);
  }

  @Override
  public boolean noDigits(String password) {
    return client.getSignUpClient().noDigits(password);
  }

  @Override
  public boolean noUpper(String password) {
    return client.getSignUpClient().noUpper(password);
  }

  @Override
  public boolean usernameExists(String username) {
    return client.getSignUpClient().usernameExists(username);
  }
}
