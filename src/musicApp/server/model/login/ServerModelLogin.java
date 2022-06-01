package musicApp.server.model.login;

import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

import java.util.ArrayList;
import java.util.List;

public interface ServerModelLogin extends Subject {
    //---------Login--------
    User signIn(String username, String password);

    void disconnect(User user);

    int getNumberOfUsers();

    boolean accountDoesNotExist(User user);

    void updateUserInfoInList(String username, String password, String email,
        String nickname, String description);

    boolean isOnline(User user);

    void updatePicturePathForUser(String username, String path);

    List<User> getUserList();
}
