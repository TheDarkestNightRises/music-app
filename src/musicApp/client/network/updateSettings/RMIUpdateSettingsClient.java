package musicApp.client.network.updateSettings;

import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMIUpdateSettingsClient implements UpdateSettingsClient
{
  private RMIServer server;

  @Override public void setServer(RMIServer server)
  {
    this.server = server;
  }

  @Override public void updateUserInfo(String username, String password,
      String email, String nickname)
  {
    try
    {
      server.getUpdateSettingsServer().updateUserInfo(username, password, email, nickname);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Cannot connect to server");
    }
    catch (Exception e)
    {
      throw e;
    }

  }
}
