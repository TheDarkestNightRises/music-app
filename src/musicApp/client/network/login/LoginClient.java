package musicApp.client.network.login;

import musicApp.server.model.User;
import musicApp.shared.networking.RMIServer;

public interface LoginClient {
    //-----------LOGIN------------

    int getNumberOfUsers();

    User signIn(String username, String password);

    void disconnect(User user);

    void setServer(RMIServer server);

    boolean accountDoesNotExist(String username, String password);

}
