package musicApp.shared.networking;

import musicApp.server.model.domainModel.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SignUpServer extends Remote {
    boolean usernameExists(String username) throws RemoteException;

    boolean noDigits(String password) throws RemoteException;

    boolean noUpper(String password) throws RemoteException;

    boolean emailNotValid(String email) throws RemoteException;

    void addArtist(User user) throws RemoteException;

    void addUser(String username, String password, String email) throws RemoteException;
}
