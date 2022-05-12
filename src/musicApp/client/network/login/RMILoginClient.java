package musicApp.client.network.login;

import musicApp.server.model.User;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;

public class RMILoginClient implements LoginClient{
    private RMIServer server;


    @Override
    public boolean signIn(String username, String password)  {
        User user = new User(username,password,"","","","",null);
        try {
            return server.getLoginServer().signIn(user);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Cant connect to server");
        }
    }

    @Override
    public int getNumberOfUsers()  {
        try {
            return server.getChatServer().getNumberOfUsers();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Cant connect to server");
        }
    }

    @Override
    public void disconnect(User user) {
        try {
            server.getLoginServer().disconnect(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setServer(RMIServer server) {
        this.server = server;
    }

    @Override public boolean accountDoesNotExist(String username,
        String password)
    {
        User user = new User(username,password,"","","","",null);
        try {
            return server.getLoginServer().accountDoesNotExist(user);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Cant connect to server");
        }
    }

}
