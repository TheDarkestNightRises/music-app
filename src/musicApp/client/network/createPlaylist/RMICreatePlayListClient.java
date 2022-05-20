package musicApp.client.network.createPlaylist;

import musicApp.shared.networking.RMIServer;

public class RMICreatePlayListClient implements CreatePlaylistClient
{
  private RMIServer server;
  public void setServer(RMIServer server) {
    this.server = server;
  }
}

