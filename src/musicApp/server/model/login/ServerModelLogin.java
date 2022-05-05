package musicApp.server.model.login;

import musicApp.database.Users.User;
import musicApp.util.Subject;

public interface ServerModelLogin extends Subject {
    //---------Login--------
    boolean SignIn(User user);
    void disconnect(User user);
    int getNumberOfUsers();
    boolean accountDoesNotExist(User user);
}
