package musicApp.shared.networking;

import musicApp.server.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer extends Remote {
    //----------Login-------------

    User signIn(String usernme, String password) throws RemoteException;

    void disconnect(User user) throws RemoteException;

    boolean accountDoesNotExist(User user) throws  RemoteException;
}
