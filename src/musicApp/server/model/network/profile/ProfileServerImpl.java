package musicApp.server.model.network.profile;

import musicApp.server.model.ServerModel;
import musicApp.shared.networking.ProfileServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProfileServerImpl implements ProfileServer {
    private final ServerModel serverModel;

    public ProfileServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.serverModel = serverModel;
    }


}
