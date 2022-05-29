package musicApp.client.views.login;

import musicApp.client.model.login.LogInManager;
import musicApp.server.model.domainModel.User;

import java.beans.PropertyChangeListener;

public class FakeLoginModel implements LogInManager {
    @Override
    public boolean signIn(String username, String password) {
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
        return false;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
