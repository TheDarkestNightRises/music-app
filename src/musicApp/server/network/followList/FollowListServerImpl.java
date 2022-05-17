package musicApp.server.network.followList;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.FollowListServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class FollowListServerImpl implements FollowListServer
{
  private ServerModel serverModel;

  public FollowListServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
  }

  @Override public List<User> getFollowList(User user) throws RemoteException
  {
    return serverModel.getModelFollowList().getFollowList(user);
  }
}
