package musicApp.shared.networking;

import musicApp.database.Users.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer extends Remote {
    //----------Login-------------

    boolean signIn(User user) throws RemoteException;

    void disconnect(User user) throws RemoteException;

    boolean accountDoesNotExist(User user) throws  RemoteException;
}
