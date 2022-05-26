package musicApp.server.network.deleteSong;

import musicApp.server.model.ServerModel;
import musicApp.shared.networking.DeleteSongServer;

public class DeleteSongServerImpl implements DeleteSongServer
{
  private ServerModel serverModel;

  public DeleteSongServerImpl(ServerModel serverModel)
  {
    this.serverModel = serverModel;
  }
}
