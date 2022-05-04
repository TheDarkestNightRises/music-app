package musicApp.server.network.register;

import musicApp.database.Users.User;
import musicApp.server.model.ServerModel;
import musicApp.shared.networking.SignUpServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SignUpServerImpl implements SignUpServer
{

  private final ServerModel serverModel;

  public SignUpServerImpl(ServerModel serverModel) throws RemoteException {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
  }

  @Override
  public void addUser(User user) {
    serverModel.getModelLogin().addUser(user);
  }

  @Override
  public boolean usernameExists(String username) {
    return serverModel.getModelLogin().usernameExists(username);
  }


  @Override
  public boolean noDigits(String password) throws RemoteException {
    return serverModel.getModelSignUp().noDigits(password);
  }

  @Override
  public boolean noUpper(String password) throws RemoteException {
    return serverModel.getModelSignUp().noUpper(password);
  }

  @Override public boolean emailNotValid(String email) throws RemoteException
  {
    return serverModel.getModelSignUp().emailNotValid(email);
  }
}
