package musicApp.server.network.followList;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.followList.ServerModelFollowList;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.shared.networking.FollowListServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class FollowListServerImpl implements FollowListServer {


    private final ServerModelFollowList serverModelFollowList;
    private final ServerModelLogin serverModelLogin;

    public FollowListServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelFollowList = serverModelFactory.getModelFollowList();
        this.serverModelLogin = serverModelFactory.getModelLogin();
    }

    @Override
    public List<User> getFollowList(User user) throws RemoteException {
        return serverModelFollowList.getFollowList(user);
    }

    @Override
    public boolean isOnline(User user) throws RemoteException {
        return serverModelLogin.isOnline(user);
    }
}
