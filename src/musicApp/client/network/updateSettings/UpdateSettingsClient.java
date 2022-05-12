package musicApp.client.network.updateSettings;

import musicApp.shared.networking.RMIServer;

public interface UpdateSettingsClient
{
  void setServer(RMIServer server);
}
