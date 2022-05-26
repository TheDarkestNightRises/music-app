package musicApp.client.network.addSong;

import musicApp.shared.networking.RMIServer;

public class RMIAddSongClient implements AddSongClient
{
  RMIServer server;
  @Override public void setServer(RMIServer server)
  {
    this.server = server;
  }
}
