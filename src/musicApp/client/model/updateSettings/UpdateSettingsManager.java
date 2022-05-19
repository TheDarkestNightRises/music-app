package musicApp.client.model.updateSettings;

import java.io.FileInputStream;

public interface UpdateSettingsManager
{

   boolean nicknameNotValid(String nick);
  void updateUserInfo(String username, String password, String email, String nickname)
      throws Exception;
  String uploadImage(String username,byte[] bytes);
}
