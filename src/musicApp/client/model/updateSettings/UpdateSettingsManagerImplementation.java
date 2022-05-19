package musicApp.client.model.updateSettings;

import musicApp.client.network.Client;

import java.io.FileInputStream;

public class UpdateSettingsManagerImplementation implements UpdateSettingsManager
{
  private Client client;
  public UpdateSettingsManagerImplementation(Client client)
  {
    this.client = client;
  }

  @Override public boolean nicknameNotValid(String nick)
  {
    return nick == null || nick.equals("");
  }

  @Override public void updateUserInfo(String username, String password,
      String email, String nickname) throws Exception
  {
    try{
      client.getUpdateSettingsclient().updateUserInfo(username, password, email, nickname);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
  }

  @Override public String uploadImage(String username, byte[] bytes)
  {
    return client.getUpdateSettingsclient().uploadImage(username, bytes);
  }
}
