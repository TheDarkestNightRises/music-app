package musicApp.server.network.login;

import musicApp.database.Users.User;
import musicApp.server.model.ServerModel;
import musicApp.shared.networking.LoginServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginServerImpl implements LoginServer {

    private final ServerModel serverModel;

    public LoginServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModel = serverModel;
    }

    @Override
    public boolean signIn(User user) {
        return serverModel.getModelLogin().isSignedIn(user);
    }


    @Override
    public void disconnect(User user) throws RemoteException {
        serverModel.getModelLogin().disconnect(user);
    }

    @Override public boolean accountDoesNotExist(User user)
    {
        return serverModel.getModelLogin().accountDoesNotExist(user);
    }

}
