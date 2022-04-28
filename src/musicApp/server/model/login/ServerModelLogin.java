package musicApp.server.model.login;

import musicApp.client.model.User;
import musicApp.util.Subject;

public interface ServerModelLogin extends Subject {
    //---------Login--------
    void addUser(User user);
    boolean usernameExists(String username);
    boolean isSignedIn(User user);
    void disconnect(User user);
    int getNumberOfUsers();
    boolean accountDoesNotExist(User user);
}
