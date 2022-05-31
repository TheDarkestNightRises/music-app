package musicApp.client.network.updateSettings;

import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMIUpdateSettingsClient implements UpdateSettingsClient
{
  private RMIServer server;

    public RMIUpdateSettingsClient(RMIServer server) {
      this.server = server;
    }

    @Override public void setServer(RMIServer server)
  {
    this.server = server;
  }

  @Override public void updateUserInfo(String username, String password,
      String email, String nickname, String description)
  {
    try
    {
      server.getUpdateSettingsServer().updateUserInfo(username, password, email, nickname, description);
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

  @Override public String uploadImage(String username, byte[] bytes)
  {
    try
    {
      return server.getUpdateSettingsServer().uploadImage(username, bytes);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      return null;
    }
  }
}
