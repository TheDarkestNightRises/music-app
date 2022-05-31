package musicApp.client.model.updateSettings;

public interface UpdateSettingsManager
{

  boolean nicknameNotValid(String nick);
  void updateUserInfo(String username, String password, String email,
      String nickname, String description) throws Exception;
  String uploadImage(String username, byte[] bytes);
}
