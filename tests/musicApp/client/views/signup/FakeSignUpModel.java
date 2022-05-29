package musicApp.client.views.signup;

import musicApp.client.model.register.SignUpManager;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public class FakeSignUpModel implements SignUpManager {
    private ArrayList<User> users;

    public FakeSignUpModel() {
        this.users = new ArrayList<>();
        populateUsers();
    }

    public void populateUsers() {
        User user = new User("emanuel","scrumMast3r");
        User user2 = new User("cosmin","Qwerty1234");
        users.add(user);
        users.add(user2);
    }

    @Override
    public boolean usernameExists(String username) {
        return false;
    }

    @Override
    public void addUser(String username, String password, String email) {

    }

    @Override
    public boolean noDigits(String password) {
        return false;
    }

    @Override
    public boolean noUpper(String password) {
        return false;
    }

    @Override
    public boolean emailNotValid(String email) {
        return false;
    }

    @Override
    public void addArtist(String username, String password, String email) {

    }
}
