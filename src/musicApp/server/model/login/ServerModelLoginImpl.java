package musicApp.server.model.login;

import musicApp.client.model.User;
import musicApp.shared.LogEntry;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerModelLoginImpl implements ServerModelLogin{

    private List<User> userList;
    private PropertyChangeSupport support;

    public ServerModelLoginImpl() {
        this.userList = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }


    @Override public void addUser(User user)
    {
        int oldValue = userList.size();
        userList.add(user);
        System.out.println(userList);
        support.firePropertyChange("OnNewUserEntry",oldValue,userList.size());
    }

    @Override public boolean usernameExists(String username)
    {
        boolean result = false;
        for(User currentUser : userList)
        {
            if (currentUser.getUsername().equals(username))
            {
                result = true;
                break;
            }
        }
        return  result;
    }


    @Override public boolean isSignedIn(User user)
    {
        System.out.println(user);
        boolean result = false;
        for (User currentUser : userList)
        {
            if (currentUser.equalsIgnoreEmail(user) && !currentUser.isLoggedIn())
            {
                result = true;
                currentUser.setLoggedIn(true);
                break;
            }
        }
        System.out.println(result);
        return result;
    }


    @Override
    public void disconnect(User user) {
        for (User currentUser : userList) {
            if (currentUser.equals(user)) currentUser.setLoggedIn(false);
        }
    }

    @Override public int getNumberOfUsers()
    {
        return userList.size();
    }

    @Override public boolean accountDoesNotExist(User user)
    {
        boolean result = true;
        for (User currentUser : userList)
        {
            if (currentUser.equalsIgnoreEmail(user))
            {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }
}
