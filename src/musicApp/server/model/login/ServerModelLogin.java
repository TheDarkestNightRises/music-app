package musicApp.server.model.login;

import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

public interface ServerModelLogin extends Subject {
    //---------Login--------
    User SignIn(String username, String password);
    void disconnect(User user);
    int getNumberOfUsers();
    boolean accountDoesNotExist(User user);

    void updateUserInfoInList(String username, String password, String email, String nickname);
    boolean isOnline(User user);
  void updatePicturePathForUser(String username, String path);
}
