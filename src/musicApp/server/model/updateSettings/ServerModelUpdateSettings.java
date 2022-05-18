package musicApp.server.model.updateSettings;

public interface ServerModelUpdateSettings
{
  void updateUserInfo(String username, String password, String email, String nickname);
}
