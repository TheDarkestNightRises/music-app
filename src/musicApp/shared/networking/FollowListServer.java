package musicApp.shared.networking;

import musicApp.server.model.domainModel.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FollowListServer extends Remote
{

  List<User> getFollowList(User user) throws RemoteException;
  boolean isOnline(User user) throws RemoteException;
}
