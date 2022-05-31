package musicApp.server.model.register;

import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

public interface ServerModelSignUp extends Subject {
    boolean noDigits(String password);

    boolean noUpper(String password);

    boolean emailNotValid(String email);

    boolean usernameExists(String username);

    void addArtist(User user);

    void addUser(String username, String password, String email);
}

