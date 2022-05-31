package musicApp.server.network.register;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.register.ServerModelSignUp;
import musicApp.shared.networking.SignUpServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SignUpServerImpl implements SignUpServer {


    private final ServerModelSignUp serverModelSignUp;

    public SignUpServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelSignUp = serverModelFactory.getModelSignUp();
    }

    @Override
    public boolean usernameExists(String username) {
        return serverModelSignUp.usernameExists(username);
    }

    @Override
    public boolean noDigits(String password) throws RemoteException {
        return serverModelSignUp.noDigits(password);
    }

    @Override
    public boolean noUpper(String password) throws RemoteException {
        return serverModelSignUp.noUpper(password);
    }

    @Override
    public boolean emailNotValid(String email) throws RemoteException {
        return serverModelSignUp.emailNotValid(email);
    }

    @Override
    public void addArtist(User user) throws RemoteException {
        serverModelSignUp.addArtist(user);
    }

    @Override
    public void addUser(String username, String password, String email) throws RemoteException {
        serverModelSignUp.addUser(username,password,email);
    }
}
