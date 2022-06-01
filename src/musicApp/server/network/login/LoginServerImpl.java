package musicApp.server.network.login;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.shared.networking.LoginServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginServerImpl implements LoginServer
{


  private final ServerModelLogin serverModelLogin;

  public LoginServerImpl(ServerModelFactory serverModelFactory) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModelLogin = serverModelFactory.getModelLogin();
  }

  @Override public User signIn(String username, String password)
  {
    return serverModelLogin.signIn(username, password);
  }

  @Override public void disconnect(User user) throws RemoteException
  {
    serverModelLogin.disconnect(user);
  }

  @Override public boolean accountDoesNotExist(User user)
  {
    return serverModelLogin.accountDoesNotExist(user);
  }

}
