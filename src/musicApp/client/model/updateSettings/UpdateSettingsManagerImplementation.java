package musicApp.client.model.updateSettings;

import musicApp.client.network.Client;

public class UpdateSettingsManagerImplementation implements UpdateSettingsManager
{
  private Client client;
  public UpdateSettingsManagerImplementation(Client client)
  {
    this.client = client;
  }
}
