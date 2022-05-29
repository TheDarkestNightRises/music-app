package musicApp.client.model.login;

import musicApp.server.model.domainModel.User;
import musicApp.client.network.Client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginManagerImplementation implements LogInManager {
    private Client client;
    private User user;
    private PropertyChangeSupport support;

    public LoginManagerImplementation(Client client) {
        this.client = client;
        this.support = new PropertyChangeSupport(this);
        client.addListener("OnNewUserEntry", this::onNewUserEntry);
    }

    private void onNewUserEntry(PropertyChangeEvent event) {
        support.firePropertyChange(event);
    }

    @Override
    public boolean signIn(String username, String password) {

         user = client.getLoginClient().signIn(username, password);
         if(user != null)
             return true;
         return false;
    }


    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void disconnect() {
        client.getLoginClient().disconnect(user);
    }

    @Override
    public String getUserName() {
        return user.getUsername();
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override public boolean accountDoesNotExist(String username,
        String password)
    {
       return  client.getLoginClient().accountDoesNotExist(username, password);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }
}
