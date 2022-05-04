package musicApp.server.model.login;

import musicApp.database.Users.User;
import musicApp.database.Users.UsersDAO;
import musicApp.database.Users.UsersDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerModelLoginImpl implements ServerModelLogin{

    private List<User> userList;
    private PropertyChangeSupport support;
    private UsersDAO d;

    public ServerModelLoginImpl() {
        this.userList = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);

    }

    @Override public void addUser(User user)
    {
        try
        {
            UsersDAO d = new UsersDAOImpl();
            d.createUser(user.getUsername(),user.getPassword(),user.getEmail());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

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
//        for (User currentUser : userList)
//        {
//            if (currentUser.equalsIgnoreEmail(user) && !currentUser.isLoggedIn())
//            {
//                result = true;
//                currentUser.setLoggedIn(true);
//                break;
//            }
//        }
        if(user.isLoggedIn())
            return false;
        try
        {
            d = new UsersDAOImpl();
            return d.accountExists(user.getUsername(),user.getPassword());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            user.setLoggedIn(true);
            userList.add(user);
        }
        return false;

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
        try
        {
            d = new UsersDAOImpl();
            if(!d.accountExists(user.getUsername(), user.getPassword()))
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
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
