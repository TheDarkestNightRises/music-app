package musicApp.server.network.updateSettings;

import musicApp.server.model.ServerModel;
import musicApp.shared.networking.UpdateSettingsServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UpdateSettingsServerImpl implements UpdateSettingsServer
{
  private final ServerModel serverModel;

  public UpdateSettingsServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
  }

  @Override public void updateUserInfo(String username, String password,
      String email, String nickname)
  {
    try {
      serverModel.getModelUpdateSettings().updateUserInfo(username, password, email, nickname);
      serverModel.getModelLogin().updateUserInfoInList(username, password, email, nickname);
    } catch (Exception e)
    {
      throw e;
    }
  }
}
