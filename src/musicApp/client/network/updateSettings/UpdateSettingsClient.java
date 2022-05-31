package musicApp.client.network.updateSettings;

import musicApp.shared.networking.RMIServer;

public interface UpdateSettingsClient
{
  void setServer(RMIServer server);
  void updateUserInfo(String username, String password, String email,
      String nickname, String description);
  String uploadImage(String username, byte[] bytes);
}
