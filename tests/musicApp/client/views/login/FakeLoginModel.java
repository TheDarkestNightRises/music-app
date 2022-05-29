package musicApp.client.views.login;

import musicApp.client.model.login.LogInManager;
import musicApp.server.model.domainModel.User;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class FakeLoginModel implements LogInManager {
    private ArrayList<User> users;

    public FakeLoginModel() {
        this.users = new ArrayList<>();
        populateUsers();
    }

    private void populateUsers() {
        User user = new User("emanuel", "scrumMast3r");
        User user2 = new User("cosmin", "Qwerty1234");
        users.add(user);
        users.add(user2);
    }

    @Override
    public boolean signIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void setUser(User user) {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public boolean accountDoesNotExist(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
