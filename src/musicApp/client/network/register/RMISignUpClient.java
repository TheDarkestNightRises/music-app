package musicApp.client.network.register;

import musicApp.client.model.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMISignUpClient implements SignUpClient
{

  private RMIServer server;


  public void setServer(RMIServer server) {
    this.server = server;
  }

  @Override public void addUser(String username, String password, String email)
  {
    User user = new User(username,password,email,"","","");
    try {
      server.getSignUpServer().addUser(user);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean usernameExists(String user)  {
    try {
      return server.getSignUpServer().usernameExists(user);
    } catch (RemoteException e) {
      e.printStackTrace();
      throw new RuntimeException("Cant connect to server");
    }
  }

  @Override public boolean noDigits(String password)
  {
    try {
      return server.getSignUpServer().noDigits(password);
    } catch (RemoteException e) {
      e.printStackTrace();
      throw new RuntimeException("Cant connect to server");
    }
  }

  @Override public boolean noUpper(String password)
  {
    try {
      return server.getSignUpServer().noUpper(password);
    } catch (RemoteException e) {
      e.printStackTrace();
      throw new RuntimeException("Cant connect to server");
    }
  }

  @Override public boolean emailNotValid(String email)
  {
    try {
      return server.getSignUpServer().emailNotValid(email);
    } catch (RemoteException e) {
      e.printStackTrace();
      throw new RuntimeException("Cant connect to server");
    }
  }
}
