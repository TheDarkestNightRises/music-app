package musicApp.client.network.deleteSong;

import musicApp.shared.networking.RMIServer;

public class RMIDeleteSongClient implements DeleteSongClient
{

  private RMIServer server;

  @Override public void setServer(RMIServer server)
  {
    this.server = server;
  }
}
