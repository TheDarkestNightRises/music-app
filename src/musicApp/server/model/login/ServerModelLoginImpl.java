package musicApp.server.model.login;

import musicApp.server.model.domainModel.User;
import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerModelLoginImpl implements ServerModelLogin {

    private List<User> userList;
    private PropertyChangeSupport support;
    private UsersDAO userDAO;

    public ServerModelLoginImpl() {
        this.userList = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public User SignIn(String username, String password) {
        try {
            for (User currentUser : userList)
                if (currentUser.isLoggedIn() && currentUser.getUsername()
                        .equals(username))
                    return null;
            if (this.userDAO.accountExists(username, password)) {
                User userLogged = userDAO.getUserByName(username);
                userLogged.setLoggedIn(true);
                System.out.println(userLogged);
                userList.add(userLogged);
                System.out.println(userList);
                return userLogged;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void disconnect(User user) {
        for (User currentUser : userList) {
            if (currentUser.getUsername().equals(user.getUsername()))
                currentUser.setLoggedIn(false);
        }
    }

    @Override
    public int getNumberOfUsers() {
        return userList.size();
    }

    @Override
    public boolean accountDoesNotExist(User user) {
        try {
            this.userDAO = new UsersDAOImpl();
            if (!this.userDAO.accountExists(user.getUsername(), user.getPassword()))
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
