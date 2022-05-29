package musicApp.client.network.login;

import musicApp.server.model.domainModel.User;
import musicApp.shared.networking.RMIServer;

public interface LoginClient {
    //-----------LOGIN------------

    int getNumberOfUsers();

    User signIn(String username, String password);

    void disconnect(User user);

    boolean accountDoesNotExist(String username, String password);

}
