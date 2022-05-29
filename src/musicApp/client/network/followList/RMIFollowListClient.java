package musicApp.client.network.followList;

import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.List;

public class RMIFollowListClient implements FollowListClient {
    private RMIServer server;

    public RMIFollowListClient(RMIServer server) {
        this.server = server;
    }

    @Override
    public List<User> getFollowList(User user) {
        try {
            return server.getFollowListServer().getFollowList(user);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Cant connect to server");
        }
    }

    @Override
    public boolean isOnline(User user) {
        try {
            return server.getFollowListServer().isOnline(user);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Cant connect to server");
        }
    }

}
