package musicApp.client.model.login;

import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

public interface LogInManager extends Subject {

    boolean signIn(String username, String password);

    void setUser(User user);

    void disconnect();

    String getUserName();

    User getUser();

    boolean accountDoesNotExist(String username, String password);
}
