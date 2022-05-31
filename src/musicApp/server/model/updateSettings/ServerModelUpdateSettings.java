package musicApp.server.model.updateSettings;

public interface ServerModelUpdateSettings
{
  void updateUserInfo(String username, String password, String email,
      String nickname, String description);
  String uploadPicture(String username, byte[] bytes);
}
